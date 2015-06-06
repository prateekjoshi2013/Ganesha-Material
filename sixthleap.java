
 	
 	import java.io.IOException;
 	import java.util.*;
 	
 	import org.apache.hadoop.fs.Path;
 	import org.apache.hadoop.conf.*;
 	import org.apache.hadoop.io.*;
 	import org.apache.hadoop.mapred.*;
 	import org.apache.hadoop.util.*;
 	import java.text.SimpleDateFormat;
	import java.text.ParseException;
	


 	public class sixthleap {
 	
public static Date parseDate(final String date) {
		  /*if (date == null) {
		    return null;
		  }*/

		  SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		  try {
		    return format.parse(date);
		  } catch (ParseException e) {
		    // Log a complaint and include date in the complaint
			 // System.out.println("found date");
			  return null;
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
		/*StringTokenizer tokenizer = new StringTokenizer(line,"\"");
 	       int i=1;
		while (i<=15 && parseDate(tokenizer.nextToken())==null) {
	 	
if(i==8)	 	
value1=new String(tokenizer.nextToken());
i++;
		}
value3=new String(tokenizer.nextToken());

*/
String phrase = value3;
String delims = "[,]";
String[] tokens = phrase.split(delims);
		
/*i=1;		
while (i<=7)
{
value2=new String(tokenizer.nextToken());
i++;
 
}*/
word.set(value1);				
word1.set(tokens[8]);
output.collect(word,word1);
 	       
 	     }
 	   }
 	
 	   public static class Reduce extends MapReduceBase implements Reducer<Text, Text , Text, Text> {
 	     public void reduce(Text key, Iterator< Text > values, OutputCollector<Text, Text> output, Reporter reporter) throws IOException {
String csv = new String("");
String csv1 = new String("");
String csv2 = new String(); 	      
String temp = new String();
double l1=0 ;
double l2=0 ;

int k=1;







while (values.hasNext())
{
csv1 += values.next().toString();
csv1 +=" ";
k++;
}

String delims = "[ ]+";
String [] tokens = csv1.split(delims);
for(int i = 0; i < tokens.length; i++)
{
csv = tokens[i];
csv = csv.replace("\"", "");
csv = csv.replace(",", "");
l1 = Double.parseDouble(csv);
l2 += l1;
}
 
l2 /= tokens.length;
csv2 = Double.toString(l2);
//csv2 = Integer.toString(tokens.length);
output.collect(key, new Text(csv2));









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


JobConf conf = new JobConf(sixthleap.class);
 	     conf.setJobName("sixthleap");
 	
 	     conf.setOutputKeyClass(Text.class);
 	     conf.setOutputValueClass(Text.class);
 	
 	     conf.setMapperClass(Map.class);
 	     conf.setCombinerClass(Reduce.class);
 	     conf.setReducerClass(Reduce.class);
 	
 	     conf.setInputFormat(KeyValueTextInputFormat.class);
 	     conf.setOutputFormat(TextOutputFormat.class);
		conf.set("key.value.separator.in.input.line", "," ); 	     
	//	conf.set("mapreduce.input.keyvaluelinerecordreader.key.value.separator", ",");
 	     FileInputFormat.setInputPaths(conf, new Path(args[0]));
 	     FileOutputFormat.setOutputPath(conf, new Path(args[1]));
 	
 	     JobClient.runJob(conf);
 	   }
 	}
