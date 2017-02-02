package com.gpch.intervals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * 
 * 
 * You are given the availability for 2 people, where the availability for each person is represented by a 2d array
 * (e.g. avail[I][0] is start time and availA[i][1] is the end time for the ith availability of person A). 
 * Also, the duration of a meeting is given. Write a method to return the earliest start time for 
 * hosting the meeting between the two.
 *
 * input:
 * availA: {[0,15], [25, 50]} (person A is available from 0 to 15, from 25 to 50)
 * availB: {[10, 100]} (person B is available from 10 to 100)
 * duration: 20
 * output: 25
 * 
 * 
 */

public class Solution {

	public static void main(String[] args) {
		List<int[]> personA = new ArrayList<int[]>();
		List<int[]> personB = new ArrayList<int[]>();
		personA.add(new int[] { 0, 15 });
		personA.add(new int[] { 25, 50 });
		personB.add(new int[] { 10, 100 });

		System.out.println(getAvailability(personA, personB, 20));

	}

	public static int getAvailability(List<int[]> personA, List<int[]> personB, int duration) {
		List<Integer> times = new ArrayList<Integer>();

		for (int i = 0; i < personA.size(); i++) {
			for (int j = 0; j < personB.size(); j++) {
				
				if (personA.get(i)[1] - personA.get(i)[0] >= duration
						&& (personB.get(j)[1] - personB.get(j)[0]) >= duration) { //Validates enough time for the meeting
					
					if (personB.get(j)[0] >= personA.get(i)[0]) { //time for personB start later than time for personA
						
						if ((personB.get(j)[0] + duration) <= personA.get(i)[1]) { //Verify if there is an overlap with enough time for the meeting
							times.add(personB.get(j)[0]);
						}
					

					} else {//time for personA start later than time for personB
						
						if (personA.get(i)[0] + duration <= personB.get(j)[1]) {//Verify if there is an overlap with enough time for the meeting
							times.add(personA.get(i)[0]);
						}
						
					}
				}

			}
		}

		System.out.println("Availability count: " + times.size());
		
		if (times.size() > 0) {
			return Collections.min(times); //Return the earliest start time for hosting the meeting
		}
		return -1;
	}

}
