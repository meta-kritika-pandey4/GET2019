package com.metacube.get2019;

import java.util.*;

/**
 * It is a class with main method.
 * @author Kritika
 *
 */
public class JobScheduler {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {
			System.out.println("Enter the no of processes");
			int n = sc.nextInt();
			int pro_id[] = new int[n];
			int ab_time[][] = new int[n][2];
			int wait_time[] = new int[n];
			int turn_time[] = new int[n];
			int completion_time[] = new int[n];
			System.out.println("Enter the process_id, arrival time and burst time of the processes");
			for (int i = 0; i < n; i++) {
					int k=0,l=1;
					System.out.print("Process ID=");
					pro_id[i] = sc.nextInt();
					System.out.print("Arrival time=");
					ab_time[i][k] = sc.nextInt();
					System.out.print("Burst time=");
					ab_time[i][l] = sc.nextInt();
					System.out.println();
			}
			Fcfs f = new Fcfs(pro_id, ab_time, n);
			f.waitingTime(pro_id, n, ab_time, wait_time);
			f.turnaroundTime(n, wait_time, ab_time, turn_time);
			f.completionTime(n, wait_time, ab_time, completion_time);
			float avg = f.avgWaitTime(n, wait_time);
			int max = f.maxWait(n, wait_time);
			f.show(n, pro_id, ab_time, wait_time, turn_time,completion_time, avg, max);
		} catch (InputMismatchException e) {
			System.out.println(e.getStackTrace());
		} finally {
			sc.close();
		}
	}
}
