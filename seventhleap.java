
 	
 	import java.io.IOException;
 	import java.util.*;
 	
 	import org.apache.hadoop.fs.Path;
 	import org.apache.hadoop.conf.*;
 	import org.apache.hadoop.io.*;
 	import org.apache.hadoop.mapred.*;
 	import org.apache.hadoop.util.*;
 	import java.text.SimpleDateFormat;
	import java.text.ParseException;
	


 	public class seventhleap {
 	
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

 	

   public static class Map extends MapReduceBase implements Mapper<Text, Text, Text, Text> {
 	     
	     private Text word = new Text();
 	     private Text word1 = new Text();
	 	     
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
String phrase = line;
StringTokenizer t1 = new StringTokenizer(phrase,",");
value4= t1.nextToken();
if(value4.equals("country_code")==false)
{

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
//value5=t1.nextToken();
//value6=t1.nextToken();


word.set(val);				
word1.set(value1+" "+value2+" "+value3+" "+value4);
output.collect(word,word1);

}

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
for(int i = 0; i < (tokens.length); i=i+4)
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
/*
csv6 = tokens[i+4];
l9 = Double.parseDouble(csv6);
l10 += l9;

csv7 = tokens[i+5];
l11 = Double.parseDouble(csv7);
l12 += l11;
//csv3=Double.toString(tokens[i+1]);
//output.collect(key, new Text(tokens[i+1]));

*/
}

l2 /= (tokens.length/6);
l4 /= (tokens.length/6);
l6 /= (tokens.length/6);
l8 /= (tokens.length/6);
//l10 /= (tokens.length/6);
//l12 /= (tokens.length/6);




csv = Double.toString(l2);
csv3 = Double.toString(l4);
csv4 = Double.toString(l6);
csv5 = Double.toString(l8);
//csv6 = Double.toString(l10);
//csv7 = Double.toString(l12);

//csv2 = Integer.toString(k);
output.collect(key, new Text(csv+" "+csv3+" "+csv4+" "+csv5));









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


JobConf conf = new JobConf(seventhleap.class);
 	     conf.setJobName("seventhleap");
 	
 	     conf.setOutputKeyClass(Text.class);
 	     conf.setOutputValueClass(Text.class);
 	
 	     conf.setMapperClass(Map.class);
    conf.setCombinerClass(Reduce.class);
//    conf.setReducerClass(Reduce.class);
 	//conf.setNumReduceTasks(3);
 	     conf.setInputFormat(KeyValueTextInputFormat.class);
 	     conf.setOutputFormat(TextOutputFormat.class);
		conf.set("key.value.separator.in.input.line", "," ); 	     
	//	conf.set("mapreduce.input.keyvaluelinerecordreader.key.value.separator", ",");
 	     FileInputFormat.setInputPaths(conf, new Path(args[0]));
 	     FileOutputFormat.setOutputPath(conf, new Path(args[1]));
 	
 	     JobClient.runJob(conf);
 	   }
 	}
