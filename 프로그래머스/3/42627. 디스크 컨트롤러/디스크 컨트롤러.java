import java.util.*;
import java.io.*;

class Solution {
    static class Job implements Comparable<Job> {
        int jobNum, comeTime, takeTime;
        
        Job(int jobNum, int comeTime, int takeTime) {
            this.jobNum = jobNum;
            this.comeTime = comeTime;
            this.takeTime = takeTime;
        }
        
        @Override
        public int compareTo(Job other) {
            return Integer.compare(this.comeTime, other.comeTime);
        }
    }
    static class Node implements Comparable<Node> {
        int takeTime, requestTime, jobNum, finishTime;
        
        Node(int takeTime, int requestTime, int jobNum) {
            this.takeTime = takeTime;
            this.requestTime = requestTime;
            this.jobNum = jobNum;
            this.finishTime = -1;
        }
        
        @Override
        public int compareTo(Node other) {
            if(this.takeTime != other.takeTime) {
                return Integer.compare(this.takeTime, other.takeTime);
            }
            
            if(this.requestTime != other.requestTime) {
                return Integer.compare(this.requestTime, other.requestTime);
            }
            
            return Integer.compare(this.jobNum, other.jobNum);
        }
    }
    
    public int solution(int[][] jobs) {
        int jobCntNum = jobs.length;
        PriorityQueue<Job> jobPq = new PriorityQueue<>();
        for(int i=0; i<jobCntNum; i++) {
            jobPq.offer(new Job(i, jobs[i][0], jobs[i][1]));
        }
        
        int currTime = jobPq.peek().comeTime;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        List<Node> finished = new ArrayList<>();
        while(!jobPq.isEmpty() || !pq.isEmpty()) {
            if(pq.isEmpty()) {
                while(true) {
                    if(!jobPq.isEmpty() && jobPq.peek().comeTime == currTime) {
                        Job curr = jobPq.poll();
                        pq.offer(new Node(curr.takeTime, currTime, curr.jobNum));
                    } else {
                        break;
                    }
                }
                if(pq.isEmpty()) {
                    Job curr = jobPq.poll();
                    currTime = curr.comeTime;
                    pq.offer(new Node(curr.takeTime, currTime, curr.jobNum));
                }
            } else {
                Node curr = pq.poll();
                curr.finishTime = currTime + curr.takeTime;
                finished.add(curr);
                while(true) {
                    if(!jobPq.isEmpty() && jobPq.peek().comeTime <= curr.finishTime ) {
                        Job currJob = jobPq.poll();
                        pq.offer(new Node(currJob.takeTime, currJob.comeTime, currJob.jobNum));
                    } else {
                        break;
                    }
                }
                currTime = curr.finishTime;
            }
        }
        
        int total = 0;
        for(Node curr : finished) {
            total += curr.finishTime - curr.requestTime;
        }
        
        int answer = total/jobCntNum;
        return answer;
    }
}