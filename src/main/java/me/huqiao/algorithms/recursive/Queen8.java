package me.huqiao.algorithms.recursive;

/**
 * 参考游戏：http://www.7k7k.com/swf/49842.htm
 * 这里尝试遍历得出所有解
 */
public class Queen8 {

    final static int col = 8;
    final static int row = 8;
    private static int count = 0;
    private static int tryCount = 0;
    public static void main(String[] args) {

        int[] solution = new int[8];
        int level = 0;
        trySolution(solution,level);
        System.out.println("Total solution:"+count);
        System.out.println("Number of verifications:"+tryCount);
    }

    private static void trySolution(int[] solution,int level){
        for(int i = 0; i < col; i++){
            solution[level] = i;
            if (checkSolution(solution, level)) {
                if(level<7) {
                    trySolution(solution, level + 1);
                }else{
                    //得出一个解
                    print(solution);
                    count++;
                }
            }
        }
    }

    private static void print(int[] solution) {
        for(int i : solution){
            System.out.print((i+1)+",");
        }
        System.out.println();
    }

    private static boolean checkSolution(int[] solution,int level) {
        tryCount++;
        for(int i = 0;i<level;i++){
            if(solution[i] == solution[level] || Math.abs(level - i) == Math.abs(solution[level] - solution[i])){
                return false;
            }
        }
        return true;
    }
}
