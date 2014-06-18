import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class TranspositionCipher {

	public static String encrypt(String inputString){
	
		int length = inputString.length();

		int squareSize = (int) Math.sqrt(length);
		double extraRowsReq = Math.ceil((length-squareSize*squareSize)/(double)squareSize);
		int rowLength =  squareSize+ (int)extraRowsReq;

		char [][] tempArray = new char [rowLength][squareSize];
	
		String outputString = "" ;
		int k =0;
		for(int i =0;i<rowLength;i++)
			for(int j=0;j<squareSize;j++)
				if(k<length)
					tempArray[i][j] = inputString.charAt(k++);
					//System.out.println(inputString.charAt(k));
				else
					tempArray[i][j] = '*';
		for(int i =0;i<squareSize;i++)
			for(int j=0;j<rowLength;j++){
				outputString += tempArray[j][i];
				//System.out.println(tempArray[j][i]);
			}
			
		return outputString;
		
	}
	
	public static String decrypt(String inputString){
		int length = inputString.length();
		//System.out.println(length);
		int squareSize = (int) Math.sqrt(length);
		double extraColsReq = Math.ceil((length-squareSize*squareSize)/(double)squareSize);
		int colLength =  squareSize+ (int)extraColsReq;
		char [][] tempArray = new char [squareSize][colLength];
		String outputString = "" ;
		int k =0;
		for(int i =0;i<squareSize;i++)
			for(int j=0;j<colLength;j++){
				if(k<length && inputString.charAt(k) != '*')
					tempArray[i][j] = inputString.charAt(k);
					//System.out.println(inputString.charAt(k));
				else
					tempArray[i][j] = '\0';
				k++;
			}
	
		for(int i =0;i<colLength;i++){
			for(int j=0;j<squareSize;j++){
				outputString += tempArray[j][i];
				
			}
			
		}
		
		return outputString ;
	}
	
	public static void main(String[] args) throws MalformedURLException {
		
		String INPUT,inputString ;
		Boolean encrypt = false ;
		String outputString = null;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			System.out.print("Enter E for encryption or any other key for decryption :");
			INPUT = br.readLine();
			if(INPUT.equals("E"))
				encrypt = true;
			System.out.print("Enter the input String : ");
			INPUT = br.readLine();
			
			inputString =INPUT.replaceAll("\\s+","");
			if(encrypt)
				outputString = encrypt(inputString);
			else
				outputString = decrypt(inputString);
						
			System.out.println(outputString);
		} catch (IOException e) {
			
			e.printStackTrace();
		}

	}

}
