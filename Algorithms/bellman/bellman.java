import java.io.*;
import java.util.Scanner;

class bellman {
	public static void main(String[] Args) {
		Scanner sc = new Scanner(System.in);
		int[][] dMat, dist, via;
		int i, j, k, n, count;
		i = j = k = n = count = 0;
		System.out.println("Enter the number of nodes");
		n = sc.nextInt();

		dMat = new int[n][n];
		dist = new int[n][n];
		via = new int[n][n];

		System.out.println("Enter matrix");
		for (i = 0; i < n; i++) {
			for (j = 0; j < n; j++) {
				dMat[i][j] = sc.nextInt();
				dMat[i][i] = 0;
				dist[i][j] = dMat[i][j];
				via[i][j] = j;
			}
		}

		do {
			count = 0;
			for (i = 0; i < n; i++) {
				for (j = 0; j < n; j++) {
					for (k = 0; k < n; k++) {

						if (dist[i][j] > dMat[i][k] + dist[k][j]) {

							dist[i][j] = dist[i][k] + dist[k][j];
							via[i][j] = k;
							count--;

						}

					}
				}
			}
		} while (count != 0);

		for (i = 0; i < n; i++) {
			for (j = 0; j < n; j++) {

				System.out.println(via[i][j] + "is" + dist[i][j]);

			}
		}

	}
}