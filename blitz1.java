import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.BlockLocation;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.hdfs.DistributedFileSystem;
import org.apache.hadoop.hdfs.protocol.DatanodeInfo;
import java.io.IOException;
 	import java.util.*;
 	//package org.myorg;
import java.io.*;
import java.util.*;
import java.net.*;
import org.apache.hadoop.fs.*;
import org.apache.hadoop.conf.*;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapred.*;
import org.apache.hadoop.util.*;
 	import org.apache.hadoop.fs.Path;
 	import org.apache.hadoop.conf.*;
 	import org.apache.hadoop.io.*;
 	import org.apache.hadoop.mapred.*;
 	import org.apache.hadoop.util.*;
 	import java.text.SimpleDateFormat;
	import java.text.ParseException;
	import org.apache.hadoop.io.DoubleWritable;
	import java.net.*;

 	public class blitz1 {

public static String p1="";	
public static boolean parseDate(final String date) {
  
  SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
  try {
	Date d = format.parse(date);    
	return true;
  } catch (ParseException e) {
    // Log a complaint and include date in the complaint
return false;  
}
 
}


public static boolean parse(final String s)
	{
		try{
			Double.parseDouble(s);
			return true;
		}
		catch (Exception e)
		{
		return 	false;
		}
		
	}


public static class Mapper1 extends MapReduceBase implements Mapper<Text, Text, Text, Text> {
  private static String count = new String();
	     private Text word = new Text();
 	     private Text word1 = new Text();
	 	
public void configure(JobConf job) {
     count = job.get("test");
}

     
		public void map(Text key, Text value, OutputCollector<Text, Text> output, Reporter reporter) throws IOException {
 	       String line = value.toString();
		String value1= new String();
	         String value2= new String();
		String value3= new String();
		String value4= new String();
		String value5= new String();
		String value6= new String();
		String value7= new String();
		String val = new String();

if(key.toString().equals("country")==false)
{
String phrase = line;
StringTokenizer t1 = new StringTokenizer(phrase,",");
String delims = "[\"]";
String[] tokens = phrase.split(delims);

for(int k=0;k< tokens.length;k++)
{
if(parseDate(tokens[k])==true)
{
val=tokens[k-2];
break;
}

}





while(parse(value1)==false)
		{value1 =t1.nextToken();
			
		}
value2=t1.nextToken();
value3=t1.nextToken();
value4=t1.nextToken();
value5=t1.nextToken();
value6=t1.nextToken();
word.set(val);				
word1.set(value1+" "+value2+" "+value3+" "+value4+" "+value5+" "+value6);

//if(tokens[1].equals(Map.count)==true)
{output.collect(word,word1);
}


 	     }
 	   }
 	
 }
 	






 	
/*
   public static class Map3 extends MapReduceBase implements Mapper<Text, Text, Text, Text> {
 	     
	     private Text word = new Text();
 	     private Text word1 = new Text();
	 	     
		public void map(Text key, Text value, OutputCollector<Text,Text> output, Reporter reporter) throws IOException {
 	       String line = value.toString();
		String value1= new String();
	        String value2= new String();
		String value3= new String();
		String value4= new String();
		String value5= new String();
		String value6= new String();
		String value7= new String();
		String val = new String();
String phrase = line;
StringTokenizer t1 = new StringTokenizer(phrase,",");

String delims = "[ ]+";
String[] tokens = phrase.split(delims);






		{value1 =(tokens[0]);
			
		}
value2=(tokens[1]);
value3= tokens[2];
value4=tokens[3];
value5=tokens[4];
value6=tokens[5];
word1.set(" ");				
word.set(value1+" "+value2+" "+value3+" "+value4+" "+value5+" "+value6);
output.collect(word1,word);



 	     }
 	   }	     
	     

*/
  public static class Map extends MapReduceBase implements Mapper<Text, Text, Text, Text> {
 	     private static String count = new String();
	     private Text word = new Text();
 	     private Text word1 = new Text();
	 	
public void configure(JobConf job) {
     count = job.get("test");
}

     
		public void map(Text key, Text value, OutputCollector<Text, Text> output, Reporter reporter) throws IOException {
 	       String line = value.toString();
		String value1= new String();
	         String value2= new String();
		String value3= new String();
		String value4= new String();
		String value5= new String();
		String value6= new String();
		String value7= new String();
		String val = new String();

if(key.toString().equals("country")==false)
{
String phrase = line;
StringTokenizer t1 = new StringTokenizer(phrase,",");
String delims = "[\"]";
String[] tokens = phrase.split(delims);

for(int k=0;k< tokens.length;k++)
{
if(parseDate(tokens[k])==true)
{
val=tokens[k-2];
break;
}

}





while(parse(value1)==false)
		{value1 =t1.nextToken();
			
		}
value2=t1.nextToken();
value3=t1.nextToken();
value4=t1.nextToken();
value5=t1.nextToken();
value6=t1.nextToken();
word.set(val);				
word1.set(value1+" "+value2+" "+value3+" "+value4+" "+value5+" "+value6);

if(tokens[1].equals(Map.count)==true)
{output.collect(word,word1);
}


 	     }
 	   }
 	
 }
 	






 	

   public static class Map3 extends MapReduceBase implements Mapper<Text, Text, Text, Text> {
 	     
	     private Text word = new Text();
 	     private Text word1 = new Text();
	 	     
		public void map(Text key, Text value, OutputCollector<Text,Text> output, Reporter reporter) throws IOException {
 	       String line = value.toString();
		String value1= new String();
	        String value2= new String();
		String value3= new String();
		String value4= new String();
		String value5= new String();
		String value6= new String();
		String value7= new String();
		String val = new String();
String phrase = line;
StringTokenizer t1 = new StringTokenizer(phrase,",");

String delims = "[ ]+";
String[] tokens = phrase.split(delims);






		{value1 =(tokens[0]);
			
		}
value2=(tokens[1]);
value3= tokens[2];
value4=tokens[3];
value5=tokens[4];
value6=tokens[5];
word1.set(" ");				
word.set(value1+" "+value2+" "+value3+" "+value4+" "+value5+" "+value6);
output.collect(word1,word);



 	     }
 	   }
 	

 



public static class Map1 extends MapReduceBase implements Mapper<Text, Text, Text, Text> {
 	     
	     private Text word = new Text();
 	     private Text word1 = new Text();
	 	     
		public void map(Text key, Text value, OutputCollector<Text,Text> output, Reporter reporter) throws IOException {
 	       String line = value.toString();
		String value1= new String();
	        String value2= new String();
		String value3= new String();
		String value4= new String();
		String value5= new String();
		String value6= new String();
		String value7= new String();
		String val = new String();

                double x1,x2,x3,x4,x5,x6;
		x1=x2=x3=x4=x5=x6=0.0;	
		double l2=0,l5=0,l6=0,l7=0,l10=0,l12=0;
String phrase = line;
//StringTokenizer t1 = new StringTokenizer(phrase,",");

String delims = "[ ]+";
String[] tokens = phrase.split(delims);


/*for(int k=0;k< tokens.length;k++)
{
if(parseDate(tokens[k])==true)
{
val=tokens[k-2];
break;
}

}

*/



//while(parse(value1)==false)
		{value1 =(tokens[0]);
			
		}
value2= tokens[1];
value3= tokens[2];
value4=tokens[3];
value5=tokens[4];
value6=tokens[5];
x1= Double.parseDouble(value1);
x2= Double.parseDouble(value2);
x3= Double.parseDouble(value3);
x4= Double.parseDouble(value4);
x5= Double.parseDouble(value5);
x6= Double.parseDouble(value6);




 String lin= new String(" ");
Configuration con = new Configuration();
FileSystem fs = FileSystem.get(con);
Path inFile = new Path("hdfs://localhost:54310/user/hduser/avg102.txt");
FSDataInputStream in = fs.open(inFile);
BufferedReader br = new BufferedReader(new InputStreamReader(in));
lin = br.readLine();
br.close();
//String delims = "[ ]+";
String[] tokens1 = lin.split(delims);

//2 4
l2=Double.parseDouble(tokens1[0].replace("avg",""));
l5=Double.parseDouble(tokens1[1]);
l6=Double.parseDouble(tokens1[2]);
l7=Double.parseDouble(tokens1[3]);
l10=Double.parseDouble(tokens1[4]);
l12=Double.parseDouble(tokens1[5]);

double d1 = 0.0,d2=0.0,d3=0.0 ;


//[{(current_jitter + current_latency)/(avg_jitter + avg_latency)} - 1] * 100
d1=(((x2+x4)/(l5+l7))-1)*100; 
//tests = [{(current_tests)/(avg_tests)} - 1] * 100
d2=(((x5)/(l10))-1)*100;
//distance = [{(current_dist)/(avg_dist)} - 1] * 100
d3=(((x6)/(l12))-1)*100;
//value1= Double.toS ;
value2= Double.toString(d1) ;
//value3= Double.toString() ;
value4= Double.toString(d2) ;
value5= Double.toString(d3) ;
//value6= Double.toString();



d1=((d1+d2+d3+x1+x3)/500) ;

value6=Double.toString(d1);

word1.set(key);				
word.set(value6);
output.collect(word1,word);



 	     }
 	   }
 












public static class Map2 extends MapReduceBase implements Mapper<Text, Text, DoubleWritable, Text> {
 	     
	     private DoubleWritable word = new DoubleWritable();
 	     private Text word1 = new Text();
	 	     
		public void map(Text key, Text value, OutputCollector<DoubleWritable, Text> output, Reporter reporter) throws IOException {
 	       String line = value.toString();
		Double value1= new Double(0.0);
	        Double value2= new Double(0.0);
		String value3= new String();
		String value4= new String();
		String value5= new String();
		String value6= new String();
		String value7= new String();
		String val = new String();
String phrase = line;
StringTokenizer t1 = new StringTokenizer(phrase,",");

//String delims = "[ ]+";
//String[] tokens = phrase.split(delims);


/*for(int k=0;k< tokens.length;k++)
{
if(parseDate(tokens[k])==true)
{
val=tokens[k-2];
break;
}

}

*/



//while(parse(value1)==false)
		{value1 =Double.parseDouble(line);
			
		}
//value2=Double.parseDouble(tokens[1]);
/*value3=t1.nextToken();
value4=t1.nextToken();
value5=t1.nextToken();
value6=t1.nextToken();*/
word.set(value1);				
//word1.set(val);
output.collect(word,key);



 	     }
 	   }
 	
 











	   public static class Reduce extends MapReduceBase implements Reducer<Text, Text , Text, Text> {
 	     public void reduce(Text key, Iterator< Text > values, OutputCollector<Text, Text> output, Reporter reporter) throws IOException {

String csv = new String("");
String csv1 = new String("");
String csv2 = new String(); 	      
String csv3 = new String();
String csv4 = new String();
String csv5 = new String();
String csv6 = new String();
String csv7 = new String();
String temp = new String();
double l1=0,l3=0,l4=0,l8=0,l9=0,l11=0 ;
double l2=0,l5=0,l6=0,l7=0,l10=0,l12=0;

int k=1;


while (values.hasNext())
{
csv1 += values.next().toString();
csv1 +=" ";

}

String delims = "[ ]+";
String [] tokens = csv1.split(delims);
for(int i = 0; i < (tokens.length); i=i+6)
{
csv = tokens[i];
l1 = Double.parseDouble(csv);
l2 += l1;

csv3 = tokens[i+1];
l3 = Double.parseDouble(csv3);
l4 += l3;

csv4 = tokens[i+2];
l5 = Double.parseDouble(csv4);
l6 += l5;

csv5 = tokens[i+3];
l7 = Double.parseDouble(csv5);
l8 += l7;

csv6 = tokens[i+4];
l9 = Double.parseDouble(csv6);
l10 += l9;

csv7 = tokens[i+5];
l11 = Double.parseDouble(csv7);
l12 += l11;


}


l2 /= (tokens.length/6);

l4 /= (tokens.length/6);
l6 /= (tokens.length/6);
l8 /= (tokens.length/6);
l10 /= (tokens.length/6);
l12 /= (tokens.length/6);


csv = Double.toString(l2);
csv3 = Double.toString(l4);
csv4 = Double.toString(l6);
csv5 = Double.toString(l8);
csv6 = Double.toString(l10);
csv7 = Double.toString(l12);



output.collect(key, new Text(csv+" "+csv3+" "+csv4+" "+csv5+" "+csv6+" "+csv7));

/*StringTokenizer t1 = new StringTokenizer(csv,",");
		int count=t1.countTokens();
		for(int l=1;l<= count;l++)
		{
			l1 +=Double.parseDouble(t1.nextToken());
		}

String phrase = csv1;
String delims = "[ ]+";
String[] tokens = phrase.split(delims);
/*
for(int s=1;s<tokens.length;s++)
	{   l1+=Double.parseDouble(tokens[s]);
	    

		/*for(int m=s + 1;m<tokens.length;m++)
	    {

	                if(tokens[s] != null && tokens[s].equals(tokens[m]))
	                {
	                  
	                tokens[m] = null; // Mark for deletion later on
	                }
	    }*/
//	}

/*
for(int i=0;i<tokens.length-1;i++)
	{if(tokens[i]!=null)
	{csv1 += tokens[i];
	csv1 += ",";
	}
	}
	if(tokens[tokens.length-1]!=null)
	csv1 += tokens[tokens.length-1];

*/

//l1=l1/count;
//csv = Double.toString(count);
// 	       output.collect(key, new Text(csv));
 	     }
 	   }
 	   public static class Reduce3 extends MapReduceBase implements Reducer<Text, Text , Text, Text> {
 	     public void reduce(Text key, Iterator< Text > values, OutputCollector<Text, Text> output, Reporter reporter) throws IOException {

String csv = new String("");
String csv1 = new String("");
String csv2 = new String(); 	      
String csv3 = new String();
String csv4 = new String();
String csv5 = new String();
String csv6 = new String();
String csv7 = new String();
String temp = new String();
double l1=0,l3=0,l4=0,l8=0,l9=0,l11=0 ;
double l2=0,l5=0,l6=0,l7=0,l10=0,l12=0;

int k=1;

//String delims = "[ ]+";
while (values.hasNext())
{
csv1 += values.next().toString();
//String [] tokens = csv1.split(delims);
//l1 = Double.parseDouble(tokens[0]);
//l2 += l1;
csv1 +=" ";
//k++;
}

String delims = "[ ]+";
String [] tokens = csv1.split(delims);
for(int i = 0; i < (tokens.length); i=i+6)
{
csv = tokens[i];
l1 = Double.parseDouble(csv);
l2 += l1;
//csv=Double.toString(tokens[i]);
//output.collect(key, new Text(tokens[i]));
csv3 = tokens[i+1];
l3 = Double.parseDouble(csv3);
l4 += l3;
csv4 = tokens[i+2];
l5 = Double.parseDouble(csv4);
l6 += l5;

csv5 = tokens[i+3];
l7 = Double.parseDouble(csv5);
l8 += l7;

csv6 = tokens[i+4];
l9 = Double.parseDouble(csv6);
l10 += l9;

csv7 = tokens[i+5];
l11 = Double.parseDouble(csv7);
l12 += l11;
//csv3=Double.toString(tokens[i+1]);
//output.collect(key, new Text(tokens[i+1]));
}

l2 /= (tokens.length/6);
l4 /= (tokens.length/6);
l6 /= (tokens.length/6);
l8 /= (tokens.length/6);
l10 /= (tokens.length/6);
l12 /= (tokens.length/6);




csv = Double.toString(l2);
csv3 = Double.toString(l4);
csv4 = Double.toString(l6);
csv5 = Double.toString(l8);
csv6 = Double.toString(l10);
csv7 = Double.toString(l12);

//csv2 = Integer.toString(k);





Configuration con = new Configuration();
FileSystem fs = FileSystem.get(con);
//Path inFile = new Path("hdfs://localhost:54310/user/hduser/ox015/part-00000");
Path outFile = new Path("hdfs://localhost:54310/user/hduser/avg102.txt");
//FSDataInputStream in = fs.open(inFile);
FSDataOutputStream out = fs.create(outFile);
//FSDataOutputStream out1 = fs.create(iter);
//BufferedReader br = new BufferedReader(new InputStreamReader(in));
BufferedWriter br1 = new BufferedWriter(new OutputStreamWriter(out));
//BufferedWriter br2 = new BufferedWriter(new OutputStreamWriter(out1));
//line = br.readLine();
temp=csv+" "+csv3+" "+csv4+" "+csv5+" "+csv6+" "+csv7;
br1.write(temp);
//String delims = "[ ]+";
//String[] tokens = line.split(delims);
//br.close();
br1.close();

output.collect(key, new Text(csv+" "+csv3+" "+csv4+" "+csv5+" "+csv6+" "+csv7));









/*StringTokenizer t1 = new StringTokenizer(csv,",");
		int count=t1.countTokens();
		for(int l=1;l<= count;l++)
		{
			l1 +=Double.parseDouble(t1.nextToken());
		}

String phrase = csv1;
String delims = "[ ]+";
String[] tokens = phrase.split(delims);
/*
for(int s=1;s<tokens.length;s++)
	{   l1+=Double.parseDouble(tokens[s]);
	    

		/*for(int m=s + 1;m<tokens.length;m++)
	    {

	                if(tokens[s] != null && tokens[s].equals(tokens[m]))
	                {
	                  
	                tokens[m] = null; // Mark for deletion later on
	                }
	    }*/
//	}

/*
for(int i=0;i<tokens.length-1;i++)
	{if(tokens[i]!=null)
	{csv1 += tokens[i];
	csv1 += ",";
	}
	}
	if(tokens[tokens.length-1]!=null)
	csv1 += tokens[tokens.length-1];

*/

//l1=l1/count;
//csv = Double.toString(count);
// 	       output.collect(key, new Text(csv));
 	     }
 	   }
 	
 	   public static void main(String[] args) throws Exception {
 	     
/*Configuration conf = new Configuration();
Job job = new Job(conf, "firstleap");
job.setOutputKeyClass(Text.class);
job.setOutputValueClass(Text.class);
job.setMapperClass(Map.class);
job.setReducerClass(Reduce.class);
job.setInputFormatClass(TextInputFormat.class);
job.setOutputFormatClass(TextOutputFormat.class);
conf.set("mapreduce.input.keyvaluelinerecordreader.key.value.separator", ",");
//job.set("key.value.separator.in.input.line", "," );
FileInputFormat.addInputPath(job, new Path(args[0]));
FileOutputFormat.setOutputPath(job, new Path(args[1]));
job.waitForCompletion(true);

*/
String temp;

JobConf conf = new JobConf(blitz1.class);
 	     conf.setJobName("blitz1");
 //----------------------
//JobConf job = (JobConf) getConf();
if(args.length>5)
{
conf.set("test", args[5]);
conf.setMapperClass(Map.class);
}
else
conf.setMapperClass(Mapper1.class);
//--------------------	
 	     conf.setOutputKeyClass(Text.class);
 	     conf.setOutputValueClass(Text.class);
 	
 	     
     conf.setCombinerClass(Reduce.class);
     conf.setReducerClass(Reduce.class);
 	
 	     conf.setInputFormat(KeyValueTextInputFormat.class);
 	     conf.setOutputFormat(TextOutputFormat.class);
		conf.set("key.value.separator.in.input.line", "," ); 	     
	//	conf.set("mapreduce.input.keyvaluelinerecordreader.key.value.separator", ",");
 	     FileInputFormat.setInputPaths(conf, new Path(args[0]));
 	     FileOutputFormat.setOutputPath(conf, new Path(args[1]));
 //blitz1.Map.count=args[6];
 	     
/*----------------------
if(args.length>5)
{
Configuration con = new Configuration();
FileSystem fs = FileSystem.get(con);
//Path inFile = new Path("hdfs://localhost:54310/user/hduser/ox015/part-00000");
Path outFile = new Path("hdfs://localhost:54310/user/hduser/param.txt");
//FSDataInputStream in = fs.open(inFile);
FSDataOutputStream out = fs.create(outFile);
//FSDataOutputStream out1 = fs.create(iter);
//BufferedReader br = new BufferedReader(new InputStreamReader(in));
BufferedWriter br1 = new BufferedWriter(new OutputStreamWriter(out));
//BufferedWriter br2 = new BufferedWriter(new OutputStreamWriter(out1));
//line = br.readLine();
if(args.length==6)
{conf.setMapperClass(Mapper1.class);
temp=args[5];
br1.write(temp);
}
if(args.length==7)
{conf.setMapperClass(Mapper1.class);
temp=args[5]+"\n";
br1.write(temp);
temp=args[6];
br1.write(temp);
}

//String delims = "[ ]+";
//String[] tokens = line.split(delims);
//br.close();
br1.close();
}

*///---------------------------

JobClient.runJob(conf);

JobConf conf3 = new JobConf(blitz1.class);
 	     conf3.setJobName("blitz1");
 	
 	     conf3.setOutputKeyClass(Text.class);
 	     conf3.setOutputValueClass(Text.class);
 	
 	     conf3.setMapperClass(Map3.class);
    // conf.setCombinerClass(Reduce.class);
     conf3.setReducerClass(Reduce3.class);
 	//conf.setNumReduceTasks(3);
 	     conf3.setInputFormat(KeyValueTextInputFormat.class);
 	     conf3.setOutputFormat(TextOutputFormat.class);
		conf3.set("key.value.separator.in.input.line", "\t" ); 	     
	//	conf.set("mapreduce.input.keyvaluelinerecordreader.key.value.separator", ",");
 	     FileInputFormat.setInputPaths(conf3, new Path(args[1]));
 	     FileOutputFormat.setOutputPath(conf3, new Path(args[4]));
 	
 	     JobClient.runJob(conf3);





JobConf conf1 = new JobConf(blitz1.class);
 	     conf1.setJobName("blitz1");
 	
 	     conf1.setOutputKeyClass(Text.class);
 	     conf1.setOutputValueClass(Text.class);
 	
 	     conf1.setMapperClass(Map1.class);
//     conf.setCombinerClass(Reduce.class);
 //    conf.setReducerClass(Reduce.class);
 	
 	     conf1.setInputFormat(KeyValueTextInputFormat.class);
 	     conf1.setOutputFormat(TextOutputFormat.class);
		conf1.set("key.value.separator.in.input.line", "\t" ); 	     
	//	conf.set("mapreduce.input.keyvaluelinerecordreader.key.value.separator", ",");
 	     FileInputFormat.setInputPaths(conf1, new Path(args[1]));
 	     FileOutputFormat.setOutputPath(conf1, new Path(args[2]));
 	
 	     JobClient.runJob(conf1);










JobConf conf2 = new JobConf(blitz1.class);
 	     conf2.setJobName("blitz1");
 	
 	     conf2.setOutputKeyClass(DoubleWritable.class);
 	     conf2.setOutputValueClass(Text.class);
 	
 	     conf2.setMapperClass(Map2.class);
     //conf.setCombinerClass(Reduce.class);
     //conf.setReducerClass(Reduce.class);
 	
 	     conf2.setInputFormat(KeyValueTextInputFormat.class);
 	     conf2.setOutputFormat(TextOutputFormat.class);
		conf2.set("key.value.separator.in.input.line", "\t" ); 	     
	//	conf.set("mapreduce.input.keyvaluelinerecordreader.key.value.separator", ",");
 	     FileInputFormat.setInputPaths(conf2, new Path(args[2]));
 	     FileOutputFormat.setOutputPath(conf2, new Path(args[3]));
 	
 	     JobClient.runJob(conf2);

 	   String line= new String(" ");

	
//p1=args[3];
/*file read and write
Configuration con = new Configuration();
FileSystem fs = FileSystem.get(con);
Path inFile = new Path("hdfs://localhost:54310/user/hduser/ox015/part-00000");
Path outFile = new Path("hdfs://localhost:54310/user/hduser/xyz8.txt");
FSDataInputStream in = fs.open(inFile);
FSDataOutputStream out = fs.create(outFile);
//FSDataOutputStream out1 = fs.create(iter);
BufferedReader br = new BufferedReader(new InputStreamReader(in));
BufferedWriter br1 = new BufferedWriter(new OutputStreamWriter(out));
//BufferedWriter br2 = new BufferedWriter(new OutputStreamWriter(out1));
line = br.readLine();
// br1.write(line);
String delims = "[ ]+";
String[] tokens = line.split(delims);
br.close();
br1.close();

*/
}
 	}
