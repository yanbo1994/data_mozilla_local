package dataprocess;

import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;

public class TransTime {
	String trans(String a){
		SimpleDateFormat format = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" );
		Long time=new Long(a);
		String str = format.format(time);
		System.out.println("Format To String(Date):"+str);

		return str;
	}
	
	void storeTime(String str){ 
		try{
			int count;
			byte buffer[] = str.getBytes();//Stringת��Ϊbyte[]
			System.out.println("buffer is: "+buffer[0]);
			FileOutputStream wf=new FileOutputStream("time.txt");
			count=System.in.read(buffer);
			wf.write(buffer,0,count);
			wf.close();
			System.out.println("sucess of storing time");
		}
		catch(IOException ieo){
			System.out.println(ieo);
		} 
		catch(Exception e){
			System.out.println(e);
		}
		
	}
	
	/*public static void main(String[] args){
		TransTime tt=new TransTime();
		tt.storeTime(tt.trans("891887820"));
	}*/
}
