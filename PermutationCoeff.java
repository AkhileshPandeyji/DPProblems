package dynamicProgCodes;
import java.util.Scanner;

public class PermutationCoeff {
	public static void main(String args[]) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int r = scn.nextInt();
		
		int P[][] = new int[n+1][r+1];
		
		P[n][0]=1;
		P[n][1]=n;
		
		for(int i=1;i<=n;i++) {
			for(int j=0;j<=r;j++) {
				if(j>i) {
					break;
				}
				if(j==0) {
					P[i][j] = 1;
					continue;
				}
				if(j==1) {
					P[i][j] = i;
					continue;
				}
				P[i][j] = j*P[i-1][j-1] + P[i-1][j];
			}
		}
		
		for(int i=0;i<=n;i++) {
			for(int j=0;j<=r;j++) {
				System.out.print(P[i][j]+":");
			}
			System.out.println();
		}
		System.out.println(P[n][r]);
	}
}
