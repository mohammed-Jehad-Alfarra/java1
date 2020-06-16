import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
class MyThread extends Thread
{
String filename;
MyThread(String fname, String tname)
{
super(tname);
filename=fname;
}
public void run()
{
FileReader fr = null;
try {
fr = new FileReader(filename);
int i;
while((i=fr.read())!=-1)
{
Thread.sleep(100);
System.out.println((char)i + " : "+getName());
}
fr.close();
} catch (Exception e) {
e.printStackTrace();
}
}
}
public class FileReaderExample {
public static void main(String args[]){
MyThread a = new MyThread("E:\\a.txt","Thread A");
MyThread b = new MyThread("E:\\b.txt","Thread B");
a.start();
b.start();
}
}