package com.metacube.get2019;

import java.util.*;

/**
 * It is a class with main method.
 * @author Admin
 *
 */
public class JobScheduler {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {
			System.out.println("Enter the no of processes");
			int n = sc.nextInt();
			int pro_id[] = new int[n];
			int arr_time[] = new int[n];
			int bur_time[] = new int[n];
			int wait_time[] = new int[n];
			int turn_time[] = new int[n];
			int completion_time[] = new int[n];
			System.out
					.println("Enter the process_id, arrival time and burst time of the processes");
			for (int i = 0; i < n; i++) {
				System.out.print("Process ID=");
				pro_id[i] = sc.nextInt();
				System.out.print("Arrival time=");
				arr_time[i] = sc.nextInt();
				System.out.print("Burst time=");
				bur_time[i] = sc.nextInt();
				System.out.println();
			}
			Fcfs f = new Fcfs(pro_id, arr_time, bur_time, n);
			f.waitingTime(pro_id, n, bur_time, arr_time, wait_time);
			f.turnaroundTime(n, wait_time, bur_time, turn_time);
			f.completionTime(n, wait_time, bur_time, completion_time, arr_time);
			float avg = f.avgWaitTime(n, wait_time);
			int max = f.maxWait(n, wait_time);
			f.show(n, pro_id, arr_time, bur_time, wait_time, turn_time,
					completion_time, avg, max);
		} catch (InputMismatchException e) {
			System.out.println(e.getStackTrace());
		} finally {
			sc.close();
		}
	}
}
