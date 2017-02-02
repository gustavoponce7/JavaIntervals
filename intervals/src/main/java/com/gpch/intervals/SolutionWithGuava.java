package com.gpch.intervals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.google.common.collect.Range;

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

public class SolutionWithGuava {

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
						&& (personB.get(j)[1] - personB.get(j)[0]) >= duration) {
					Range<Integer> range1 = Range.closed(personA.get(i)[0], personA.get(i)[1]);
					Range<Integer> range2 = Range.closed(personB.get(j)[0], personB.get(j)[1]);
					if (range1.isConnected(range2)) {

						Range<Integer> interception = range1.intersection(range2);

						if ((interception.upperEndpoint() - interception.lowerEndpoint()) >= duration) {
							times.add(interception.lowerEndpoint());
						}
					}

				}
			}
		}

		System.out.println("Availability count: " + times.size());

		if (times.size() > 0) {
			return Collections.min(times);
		}
		return -1;

	}

}
