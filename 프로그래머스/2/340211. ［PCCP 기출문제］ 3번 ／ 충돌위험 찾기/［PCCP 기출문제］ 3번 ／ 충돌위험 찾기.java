class Solution {
    static class Robot {
        int cx, cy, tindex;
        boolean isDone;
        
        Robot(int cx, int cy) {
            this.cx = cx;
            this.cy = cy;
            this.tindex = 1;
            this.isDone = false;
        }
    }
    
    public int solution(int[][] points, int[][] routes) {
        int robotN = routes.length;
        int answer = 0;
        
        Robot[] robots = new Robot[robotN];
        
        for(int i=0; i<robotN; i++) {
            robots[i] = new Robot(
                points[routes[i][0]-1][0], 
                points[routes[i][0]-1][1]
            );
        }
                                  
        while(!allDone(robots)) {
            // 충돌 위험 신호 확인 (카운팅)
            int[][] countMap = new int[101][101];
            for(int i=0;  i<robotN; i++) {
                if(robots[i].isDone) continue;
                
                int cx = robots[i].cx;
                int cy = robots[i].cy;
                
                countMap[cx][cy]++;

                if(countMap[cx][cy] == 2) {
                    answer++;
                }
            }
            
            for(int i = 0; i < robotN; i++) {

                if(robots[i].isDone) continue;

                if(robots[i].tindex == routes[i].length) {
                    robots[i].isDone = true;
                }
            }

            // 배달 완료 확인 & 이동
            for(int i=0;  i<robotN; i++) {
                if(!robots[i].isDone) {
                    int target = routes[i][robots[i].tindex]-1;
                    int cx = robots[i].cx;
                    int cy = robots[i].cy;
                    int tx = points[target][0];
                    int ty = points[target][1];

                    if(cx != tx) {
                        if(cx < tx) cx++;
                        else cx--;
                    } else {
                        if(cy != ty) {
                            if(cy < ty) cy++;
                            else cy--;
                        }
                    }
                    robots[i].cx = cx;
                    robots[i].cy = cy;
                    
                    if(cx == tx && cy == ty) {
                        robots[i].tindex++;
                    }
                }
            }
        }
        

        return answer;
    }
    
    public boolean allDone(Robot[] robots) {
        for(Robot r : robots) {
            if(!r.isDone) return false;
        }
        
        return true;
    }
}