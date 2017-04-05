package microsoft;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class Question2 {
	public static void main(String[] args) {

		int N, M, K;
		Scanner scanner = new Scanner(System.in);
		N = scanner.nextInt();
		M = scanner.nextInt();
		K = scanner.nextInt();
		int[] depthNum = new int[M];
		for (int i = 0; i < M; i++) {
			depthNum[i] = scanner.nextInt();
		}
		List<int[]> tree = new ArrayList<int[]>();
		for (int i = 0; i < M; i++) {
			int[] row = new int[depthNum[i]];
			for (int j = 0; j < depthNum[i]; j++) {
				row[j] = scanner.nextInt();
			}
			tree.add(row);
		}
		// leafs
		List<Integer> leafList = new ArrayList<Integer>();
		HashSet<Integer> leafSet = new HashSet<Integer>();
		for (int i = 0; i < K; i++) {
			int node = scanner.nextInt();
			leafList.add(node);
			leafSet.add(node);
		}
		int[][] distance = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				distance[i][j] = 0;
			}
		}

		for (int i = 0; i < K; i++) {
			for (int j = 0; j < K; j++) {
				int x = leafList.get(i);
				int y = leafList.get(j);
				distance[x][y] = scanner.nextInt();
			}
		}

		int[] parent = new int[N + 1];
		for (int level = M - 1; level >= 0; level--) {
			// 这里需要根据：
			// 1.当前叶子节点集合
			// 2.当前层内容
			// 3.距离信息
			// 逐步去掉当前层的叶子节点，并生成新的叶节点。并更新距离

			// 找上一层的第一个坐标
			int upIndex = 0;
			int target = 0;
			if (level > 0) {
				for (int k = 0; k < tree.get(level - 1).length; k++) {
					if (leafSet.contains(tree.get(level - 1)[k]) == true) {
						continue;
					} else {
						upIndex = k;
						break;
					}
				}
				target = tree.get(level - 1)[upIndex];
			} else {
				target = 0;
			}
			for (int j = 0; j < tree.get(level).length; j++) {
				// 处理到当前层了，肯定是叶子
				// 判断它和下一个叶子的距离
				int curNode = tree.get(level)[j];
				// 向右搜索一直找到距离不是2为止
				int end = tree.get(level).length - 1;
				for (int p = j + 1; p < tree.get(level).length; p++) {
					int rightNode = tree.get(level)[p];
					int dis = distance[curNode][rightNode];
					if (dis == 2) {
						continue;
					} else {
						end = p - 1;
						break;
					}
				}
				// 上述[j, end]共享祖先，设定祖先值
				for (int p = j; p <= end; p++) {
					int rightNode = tree.get(level)[p];
					parent[rightNode] = target;
					// 更新上一层祖先和当前节点所有关联节点的距离
					for (int k = 0; k < N; k++) {
						if (distance[rightNode][k] != 0) {
							distance[target][k] = distance[rightNode][k] - 1;
						}
						if (distance[k][rightNode] != 0) {
							distance[k][target] = distance[k][rightNode] - 1;
						}
					}
				}
				leafSet.add(target);
				if (level > 0) {
					// 设定上一层下一个祖先的坐标
					for (int k = upIndex + 1; k < tree.get(level - 1).length; k++) {
						if (leafSet.contains(tree.get(level - 1)[k]) == true) {
							continue;
						} else {
							upIndex = k;
							break;
						}
					}
					target = tree.get(level - 1)[upIndex];
				}
				j += end - j;
			}

		}

		for (int i = 1; i <= N; i++) {
			System.out.print(parent[i]);
			if (i < N) {
				System.out.print(" ");
			} else {
				System.out.println();
			}
		}

	}
}

/*
import java.util.Scanner;

public class Main {
 
 static int n;
 static int m;
 static int k;
 
 static int[] countForLevel = new int[110];
 static int[] leftLeaf = new int[110];
 static int[][] nodes = new int[110][110];
 static int[] leaf = new int[110];
 static int[] isLeaf = new int[110];
 static int[][] dis = new int[110][110];
 static int[] parent = new int[110];
 
 public static void main(String args[]){
  Scanner sc = new Scanner(System.in);
  n = sc.nextInt();
  m = sc.nextInt();
  k = sc.nextInt();
  
  for(int i = 0 ; i < m; i ++){
   countForLevel[i] = sc.nextInt(); 
  }
  
  for(int i = 0 ; i < m ; i ++){
   for(int j = 0 ; j < countForLevel[i]; j ++){
    nodes[i][j] = sc.nextInt();
   }
   //设置每一层最左边的叶子节点的编号
   leftLeaf[i] = 0;
  }
  
  for(int i = 0 ; i < k; i ++){
   leaf[i] = sc.nextInt();
   isLeaf[leaf[i]] = 1;
  }
  
  
  for(int i = 0 ; i < k; i ++){
   for(int j = 0 ; j < k ; j ++){
    dis[leaf[i]][leaf[j]] = sc.nextInt();
   }
  }
  
  for(int l =  m - 1;l > 0 ; l -- ){
   for(int i = 0 ; i < countForLevel[l]; ){
    //先给最左边赋值
    parent[nodes[l][i]] = findLeftNode(l - 1);
    int preI = i;
    i = findBrother(l, i);
    isLeaf[parent[nodes[l][preI]]] = 1;
   }
   updateDis(l);
  }
  StringBuilder sb = new StringBuilder();
  for(int i = 1; i <= n ; i ++){
   sb.append(parent[i]);
   if(i != n){
    sb.append(" ");
   }
  }
  System.out.println(sb);
  sc.close();
 }
 
// public static void updateDis(int l){
//  for(int i = 0 ; i < countForLevel[l]; i ++){
//   for(int j = i + 1; j < countForLevel[l]; j ++){
//    int a = nodes[l][i];
//    int b = nodes[l][j];
//    if(parent[a] != parent[b] && dis[a][b] != 0){
//     dis[parent[a]][parent[b]] = dis[a][b] - 2;
//     dis[parent[b]][parent[a]] = dis[a][b] - 2;
//    }
//   }
//  }
// }
 
 public static void updateDis(int l){
  for(int i = 0 ; i < countForLevel[l]; i ++){
   for(int j = 1; j <= n; j ++){
    int a = nodes[l][i];
    if(dis[a][j] != 0){
     dis[parent[a]][j] = dis[a][j] - 1;
     dis[j][parent[a]] = dis[a][j] - 1;
    }
   }
   for(int j = i + 1; j < countForLevel[l]; j ++){
    int a = nodes[l][i];
    int b = nodes[l][j];
    if(parent[a] != parent[b] && dis[a][b] != 0){
     dis[parent[a]][parent[b]] = dis[a][b] - 2;
     dis[parent[b]][parent[a]] = dis[a][b] - 2;
    }
   }
  }
 }
 
 public static int findBrother(int l, int i){
  int j = i + 1;
  for( ; j < countForLevel[l] ; j ++){
   if(dis[nodes[l][i]][nodes[l][j]] == 2){
    parent[nodes[l][j]] = parent[nodes[l][i]];
   }else{
    return j;
   }
  }
  return j;
 }
 
 public static int findLeftNode(int l){
  for(int i = 0 ; i < countForLevel[l]; i ++){
   if(isLeaf[nodes[l][i]] == 0){
    return nodes[l][i];
   }
  }
  return nodes[l][countForLevel[l] - 1];
 }
}
*/