package com.company.process;
import java.io.IOException;
import java.util.Scanner;

public class MatrixUDG {

    private int mEdgNum;        // �ߵ�����
    private char[] mVexs;       // ���㼯��
    private int[][] mMatrix;    // �ڽӾ���
    private static final int INF = Integer.MAX_VALUE;   // ���ֵ

    /* 
     * ����ͼ(�Լ���������)
     */
    public MatrixUDG() {

    }
    /*
     * ����ͼ(�����ṩ�ľ���)
     *
     * ����˵����
     *     vexs  -- ��������
     *     matrix-- ����(����)
     */
    public MatrixUDG(char[] vexs, int[][] matrix) {
        
        // ��ʼ��"������"��"����"
        int vlen = vexs.length;

        // ��ʼ��"����"
        mVexs = new char[vlen];
        for (int i = 0; i < mVexs.length; i++)
            mVexs[i] = vexs[i];

        // ��ʼ��"��"
        mMatrix = new int[vlen][vlen];
        for (int i = 0; i < vlen; i++)
            for (int j = 0; j < vlen; j++)
                mMatrix[i][j] = matrix[i][j];

        // ͳ��"��"
        mEdgNum = 0;
        for (int i = 0; i < vlen; i++)
            for (int j = i+1; j < vlen; j++)
                if (mMatrix[i][j]!=INF)
                    mEdgNum++;
    }

    /*
     * ����chλ��
     */
    private int getPosition(char ch) {
        for(int i=0; i<mVexs.length; i++)
            if(mVexs[i]==ch)
                return i;
        return -1;
    }

    /*
     * ��ȡһ�������ַ�
     */
    private char readChar() {
        char ch='0';

        do {
            try {
                ch = (char)System.in.read();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } while(!((ch>='a'&&ch<='z') || (ch>='A'&&ch<='Z')));

        return ch;
    }

    /*
     * ��ȡһ�������ַ�
     */
    private int readInt() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    /*
     * ���ض���v�ĵ�һ���ڽӶ����������ʧ���򷵻�-1
     */
    private int firstVertex(int v) {

        if (v<0 || v>(mVexs.length-1))
            return -1;

        for (int i = 0; i < mVexs.length; i++)
            if (mMatrix[v][i]!=0 && mMatrix[v][i]!=INF)
                return i;

        return -1;
    }

    /*
     * ���ض���v�����w����һ���ڽӶ����������ʧ���򷵻�-1
     */
    private int nextVertex(int v, int w) {

        if (v<0 || v>(mVexs.length-1) || w<0 || w>(mVexs.length-1))
            return -1;

        for (int i = w + 1; i < mVexs.length; i++)
            if (mMatrix[v][i]!=0 && mMatrix[v][i]!=INF)
                return i;

        return -1;
    }

    /*
     * ���������������ͼ�ĵݹ�ʵ��
     */
    private void DFS(int i, boolean[] visited) {

        visited[i] = true;
        System.out.printf("%c ", mVexs[i]);
        // �����ö���������ڽӶ��㡣����û�з��ʹ�����ô����������
        for (int w = firstVertex(i); w >= 0; w = nextVertex(i, w)) {
            if (!visited[w])
                DFS(w, visited);
        }
    }

    /*
     * ���������������ͼ
     */
    public void DFS() {
        boolean[] visited = new boolean[mVexs.length];       // ������ʱ��

        // ��ʼ�����ж��㶼û�б�����
        for (int i = 0; i < mVexs.length; i++)
            visited[i] = false;

        System.out.printf("DFS: ");
        for (int i = 0; i < mVexs.length; i++) {
            if (!visited[i])
                DFS(i, visited);
        }
        System.out.printf("\n");
    }

    /*
     * ����������������������Ĳ�α�����
     */
    public void BFS() {
        int head = 0;
        int rear = 0;
        int[] queue = new int[mVexs.length];            // �������
        boolean[] visited = new boolean[mVexs.length];  // ������ʱ��

        for (int i = 0; i < mVexs.length; i++)
            visited[i] = false;

        System.out.printf("BFS: ");
        for (int i = 0; i < mVexs.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                System.out.printf("%c ", mVexs[i]);
                queue[rear++] = i;  // �����
            }

            while (head != rear) {
                int j = queue[head++];  // ������
                for (int k = firstVertex(j); k >= 0; k = nextVertex(j, k)) { //k��Ϊ���ʵ��ڽӶ���
                    if (!visited[k]) {
                        visited[k] = true;
                        System.out.printf("%c ", mVexs[k]);
                        queue[rear++] = k;
                    }
                }
            }
        }
        System.out.printf("\n");
    }

    /*
     * ��ӡ�������ͼ
     */
    public void print() {
        System.out.printf("Martix Graph:\n");
        for (int i = 0; i < mVexs.length; i++) {
            for (int j = 0; j < mVexs.length; j++)
                System.out.printf("%10d ", mMatrix[i][j]);
            System.out.printf("\n");
        }
    }

   
    
    /* 
     * ��ȡͼ�еı�
     */
    private EData[] getEdges() {
        int index=0;
        EData[] edges;

        edges = new EData[mEdgNum];
        for (int i=0; i < mVexs.length; i++) {
            for (int j=i+1; j < mVexs.length; j++) {
                if (mMatrix[i][j]!=INF) {
                    edges[index++] = new EData(mVexs[i], mVexs[j], mMatrix[i][j]);
                }
            }
        }

        return edges;
    }

    /* 
     * �Ա߰���Ȩֵ��С��������(��С����)
     */
    private void sortEdges(EData[] edges, int elen) {

        for (int i=0; i<elen; i++) {
            for (int j=i+1; j<elen; j++) {

                if (edges[i].weight > edges[j].weight) {
                    // ����"��i"��"��j"
                    EData tmp = edges[i];
                    edges[i] = edges[j];
                    edges[j] = tmp;
                }
            }
        }
    }

    /*
     * ��ȡi���յ�
     */
    private int getEnd(int[] vends, int i) {
        while (vends[i] != 0)
            i = vends[i];
        return i;
    }

    /*
     * Dijkstra���·����
     * ����ͳ��ͼ��"����vs"������������������·����
     *
     * ����˵����
     *       vs -- ��ʼ����(start vertex)��������"����vs"��������������·����
     *     prev -- ǰ���������顣����prev[i]��ֵ��"����vs"��"����i"�����·����������ȫ�������У�λ��"����i"֮ǰ���Ǹ����㡣
     *     dist -- �������顣����dist[i]��"����vs"��"����i"�����·���ĳ��ȡ�
     */
    public void dijkstra(int vs, int[] prev, int[] dist) {
        // flag[i]=true��ʾ"����vs"��"����i"�����·���ѳɹ���ȡ
        boolean[] flag = new boolean[mVexs.length];
        
        // ��ʼ��
        for (int i = 0; i < mVexs.length; i++) {
            flag[i] = false;          // ����i�����·����û��ȡ����
            prev[i] = 0;              // ����i��ǰ������Ϊ0��
            dist[i] = mMatrix[vs][i];  // ����i�����·��Ϊ"����vs"��"����i"��Ȩ��
        }

        // ��"����vs"������г�ʼ��
        flag[vs] = true;
        dist[vs] = 0;

        // ����mVexs.length-1�Σ�ÿ���ҳ�һ����������·����
        int k=0;
        for (int i = 1; i < mVexs.length; i++) {
            // Ѱ�ҵ�ǰ��С��·����
            // ������δ��ȡ���·���Ķ����У��ҵ���vs����Ķ���(k)��
            int min = INF;
            for (int j = 0; j < mVexs.length; j++) {
                if (flag[j]==false && dist[j]<min) {
                    min = dist[j];
                    k = j;
                }

            }
            System.out.printf("If the road of %c to %c exists,the distance is %d.", mVexs[vs],mVexs[k],min);
            // ���"����k"Ϊ�Ѿ���ȡ�����·��
            flag[k] = true;

            // ������ǰ���·����ǰ������
            // �������Ѿ�"����k�����·��"֮�󣬸���"δ��ȡ���·���Ķ�������·����ǰ������"��
            for (int j = 0; j < mVexs.length; j++) {
                //�����޸ĵ�����㣬���۱�׼�ϵķ���
                //Լ������
                int tmp = (mMatrix[k][j]==INF ? INF : (min + mMatrix[k][j]));
                if (flag[j]==false && (tmp<dist[j]) ) {
                    if(mVexs[vs]=='B'&&mVexs[j]=='F'){
                        if(mVexs[k]=='D'){
                            dist[j] = tmp;
                            prev[j] = k;
                            System.out.printf("At present,the last road of %c to %c is %c to %c,distance is %d,total distance is %d.", mVexs[vs],mVexs[j],mVexs[k],mVexs[j],mMatrix[k][j],tmp);
                        }
                    }
                    else{
                        dist[j] = tmp;
                        prev[j] = k;
                        System.out.printf("At present,the last road of %c to %c is %c to %c,distance is %d,total distance is %d.", mVexs[vs],mVexs[j],mVexs[k],mVexs[j],mMatrix[k][j],tmp);
                    }
                }
            }
            System.out.printf("\n");
        }

        // ��ӡdijkstra���·���Ľ��
        System.out.printf("dijkstra(%c): \n", mVexs[vs]);
        for (int i=0; i < mVexs.length; i++)
            System.out.printf("  shortest(%c, %c)=%d\n", mVexs[vs], mVexs[i], dist[i]);
    }

    // �ߵĽṹ��
    private static class EData {
        char start; // �ߵ����
        char end;   // �ߵ��յ�
        int weight; // �ߵ�Ȩ��

        public EData(char start, char end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }
    };


    public void demo(char[] vexs,int matrix[][]) {
        MatrixUDG pG;

        // �Զ���"ͼ"(����������)
        //pG = new MatrixUDG();
        // �������е�"ͼ"
        pG = new MatrixUDG(vexs, matrix);

        pG.print();   // ��ӡͼ
        //pG.DFS();     // ������ȱ���
        //pG.BFS();     // ������ȱ���
       

        int[] prev = new int[pG.mVexs.length];
        int[] dist = new int[pG.mVexs.length];
        // dijkstra�㷨��ȡ"��4������"�����������������̾���
        pG.dijkstra(1, prev, dist);
        //pG.dijkstra(2, prev, dist);
        //pG.dijkstra(3, prev, dist);
        //pG.dijkstra(4, prev, dist);
    }
}