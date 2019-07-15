package com.metacube.get2019;
import java.util.*;

/**
 * This class has all the operations
 * that is to be performed by
 * a FCFS scheduler
 * @author Admin
 *
 */
public class Fcfs
{
	/**
	 * It is method to schedule the processes in FCFS manner
	 * @param pro_id[]
	 * @param arr_time[]
	 * @param bur_time[]
	 * @param n
	 * @return decimal value
	 */
	public Fcfs(int[] pro_id,int[] arr_time, int[] bur_time,int n)
	{
		for(int i=0;i<n;i++)
		{
			for (int j = i + 1; j < n; j++) 
			{
				if (arr_time[i] > arr_time[j]) 
				{
					int temp=arr_time[i];
					arr_time[i]=arr_time[j];
					arr_time[j]=temp;
					
					int temp1=bur_time[i];
					bur_time[i]=bur_time[j];
					bur_time[j]=temp1;
					
					int temp2=pro_id[i];
					pro_id[i]=pro_id[j];
					pro_id[j]=temp2;
				}
			}
         }
	}
	
	/**
	 * It is method to calculate waiting time of the processes
	 * @param pro_id[]
	 * @param n
	 * @param bur_time[]
	 * @param arr_time[]
	 * @param wait_time[]
	 */
	public void waitingTime(int pro_id[],int n,int bur_time[],int arr_time[],int wait_time[])
	{
	    int service_time[] = new int[n];  
		service_time[0] = 0;  
		wait_time[0]=0;
		  
		// calculating waiting time  
		for (int i = 1; i < n ; i++)  
		{  
		    service_time[i] = service_time[i-1] + bur_time[i-1];    
		    wait_time[i] = service_time[i] - arr_time[i];  
		    if (wait_time[i] < 0)  
		    	wait_time[i] = 0;  
		 }
	}
	
	/**
	 * It is method to calculate turnaround time of the processes
	 * @param n
	 * @param pro_id[]
	 * @param wait_time[]
	 * @param bur_time[]
	 * @param turn_time[]
	 */
	public void turnaroundTime(int n,int wait_time[],int bur_time[],int turn_time[])
	{
		for(int i=0;i<n;i++)
		{
			turn_time[i]=wait_time[i]+bur_time[i];
		}
	}
	
	/**
	 * It is method to calculate completion time of the processes
	 * @param n
	 * @param wait_time[]
	 * @param bur_time[]
	 * @param completion_time[]
	 * @param arr_time[]
	 */
	public void completionTime(int n,int wait_time[],int bur_time[],int completion_time[],int arr_time[])
	{
		for(int i=0;i<n;i++)
		{
			completion_time[i]=wait_time[i]+bur_time[i]+arr_time[i];
		}
	}
	
	/**
	 * It is method to calculate average wait time of the processes
	 * @param n
	 * @param wait_time[]
	 * @return avg 
	 */
	public float avgWaitTime(int n,int wait_time[])
	{
		int sum=0;
		for(int i=0;i<n;i++)
		{
			sum+=wait_time[i];
		}
		float avg=sum/n;
		return avg;
	}
	
	/**
	 * It is method to find the maximum wait time of the processes
	 * @param n
	 * @param wait_time[]
	 * @return max
	 */
	public int maxWait(int n,int wait_time[])
	{
		int max=wait_time[0];
		for(int i=0;i<n;i++)
		{
			if(wait_time[i]>max)
				max=wait_time[i];
		}
		return max;
	}
	
	/**
	 * It is method to calculate completion time of the processes
	 * @param n
	 * @param pro_id[]
	 * @param arr_time[]
	 * @param bur_time[]
	 * @param wait_time[]
	 * @param turn_time[]
	 * @param completion_time[]
	 * @param avg
	 * @param max
	 */
	public void show(int n,int pro_id[],int arr_time[],int bur_time[],int wait_time[],int turn_time[],int completion_time[],float avg,int max)
	{
		System.out.println("PROCESS_ID\tARRIVAL TIME\tBURST TIME\tWAIT TIME\tTURNAROUND TIME\tCOMPLETION TIME\t");
		for(int i=0;i<n;i++)
		{
			System.out.println(pro_id[i]+"\t"+arr_time[i]+"\t"+bur_time[i]+"\t"+wait_time[i]+"\t"+turn_time[i]+"\t"+completion_time[i]);
		}
	}
}
