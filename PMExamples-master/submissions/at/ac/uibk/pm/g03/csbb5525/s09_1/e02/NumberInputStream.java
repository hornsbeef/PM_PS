package at.ac.uibk.pm.g03.csbb5525.s09_1.e02;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class NumberInputStream extends InputStream implements AutoCloseable{

    private final InputStream inputStream;

    public NumberInputStream(InputStream in) {
        this.inputStream = in;
    }

    public NumberInputStream(Path pathToFile){

        byte[] byteArray = getByteArray(pathToFile);
        this.inputStream = new ByteArrayInputStream(byteArray);
    }

    //is this a correct implementation of Autoclosable?
    @Override
    public void close(){
        if(inputStream != null){
            try{
                inputStream.close();
            }catch (IOException e){
                throw new RuntimeException("Exception while closing InputStream", e);
            }
        }
    }

    @Override
    public int read() throws IOException {
        var in = inputStream.read();
        if(in == '-'|| in == ' '){
            return read(); // this should skip to the next byte
        }
        return in;
    }


    //private static byte[] getByteArray(Path pathToFile) {
    //    byte[] byteArray;
    //    List<Byte> byteList = new ArrayList<>();
    //    int byteInput;
    //    Byte[] ByteArray;
    //    try(InputStream in = new FileInputStream(pathToFile.toFile())){
    //        while( (byteInput = in.read()) != -1 ){
    //            byteList.add((byte)byteInput);  //is there a better way than to cast?
    //            //this cast "should" be ok, because, FileInputStream provides "bytes"
    //        }
    //        ByteArray = byteList.toArray(new Byte[0]);
    //        byteArray = new byte[ByteArray.length];
    //        for(int i = 0; i < ByteArray.length; i++){
    //            byteArray[i] = ByteArray[i];
    //        }
    //    } catch (FileNotFoundException e) {
    //        throw new RuntimeException("File Not Found!", e);
    //    } catch (IOException e) {
    //        throw new RuntimeException("IO Exception!", e);
    //    }
    //    return byteArray;
    //}

    //this is probably better:
    private static byte[] getByteArray(Path pathToFile){
        try{
            return Files.readAllBytes(pathToFile);
        }catch(IOException ioE){
            throw new RuntimeException("IOException while reading file", ioE);
        }
    }


}
