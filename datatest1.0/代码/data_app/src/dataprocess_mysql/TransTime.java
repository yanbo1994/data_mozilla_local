package dataprocess_mysql;

import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;

public class TransTime {
	public String trans(String a){
		SimpleDateFormat format = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" );
		Long time=new Long(a);
		String str = format.format(time*1000);
		//System.out.println("Format To String(Date):"+str);

		return str;
	}
	
	void storeTime(String str){ 
		try{
			byte buffer[] = str.getBytes();//Stringת��Ϊbyte[]
			System.out.println("buffer[0] is: "+buffer[0]);
			FileOutputStream wf=new FileOutputStream("time.txt");
			wf.write(buffer,0,buffer.length);
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
