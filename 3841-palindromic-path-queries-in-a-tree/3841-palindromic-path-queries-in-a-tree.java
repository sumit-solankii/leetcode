
import java.util.*;

class Solution {
    int LOG;
    int[] tin, tout, depth;
    int[][] up;
    int timer;
    int[] parent;
    int[] nextIndex;
    List<Integer>[] adj;
    Fenwick bit;

    class Fenwick {
        int[] tree;
        int n;

        Fenwick(int n) {
            this.n = n;
            tree = new int[n + 1];
        }

        void add(int idx, int val) {
            for (int i = idx + 1; i <= n; i += i & -i) {
                tree[i] ^= val;
            }
        }

        int query(int idx) {
            int ans = 0;
            for (int i = idx + 1; i > 0; i -= i & -i) {
                ans ^= tree[i];
            }
            return ans;
        }

        void rangeXor(int l, int r, int val) {
            add(l, val);
            if (r + 1 < n) {
                add(r + 1, val);
            }
        }
    }

    public List<Boolean> palindromePath(int n, int[][] edges,
                                        String s, String[] queries) {
        adj = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int[] e : edges) {
            adj[e[0]].add(e[1]);
            adj[e[1]].add(e[0]);
        }

        LOG = 1;
        while ((1 << LOG) <= n) {
            LOG++;
        }

        tin = new int[n];
        tout = new int[n];
        depth = new int[n];
        up = new int[LOG][n];
        parent = new int[n];
        nextIndex = new int[n];

        Arrays.fill(parent, -1);

        int[] stack = new int[n];
        int top = 0;
        timer = 0;

        stack[top++] = 0;
        parent[0] = 0;
        tin[0] = timer++;

        while (top > 0) {
            int u = stack[top - 1];

            if (nextIndex[u] < adj[u].size()) {
                int v = adj[u].get(nextIndex[u]++);

                if (v == parent[u]) {
                    continue;
                }

                parent[v] = u;
                depth[v] = depth[u] + 1;
                tin[v] = timer++;
                stack[top++] = v;
            } else {
                tout[u] = timer - 1;
                top--;
            }
        }

        for (int i = 0; i < n; i++) {
            up[0][i] = parent[i];
        }

        for (int k = 1; k < LOG; k++) {
            for (int i = 0; i < n; i++) {
                up[k][i] = up[k - 1][up[k - 1][i]];
            }
        }

        bit = new Fenwick(n);
        char[] chars = s.toCharArray();

        for (int i = 0; i < n; i++) {
            int mask = 1 << (chars[i] - 'a');
            bit.rangeXor(tin[i], tout[i], mask);
        }

        List<Boolean> result = new ArrayList<>();

        for (String q : queries) {
            String[] parts = q.split(" ");

            if (parts[0].equals("update")) {
                int u = Integer.parseInt(parts[1]);
                char c = parts[2].charAt(0);

                if (chars[u] != c) {
                    int delta = (1 << (chars[u] - 'a'))
                              ^ (1 << (c - 'a'));

                    bit.rangeXor(tin[u], tout[u], delta);
                    chars[u] = c;
                }
            } else {
                int u = Integer.parseInt(parts[1]);
                int v = Integer.parseInt(parts[2]);

                int w = lca(u, v);

                int mask = bit.query(tin[u])
                         ^ bit.query(tin[v])
                         ^ (1 << (chars[w] - 'a'));

                result.add((mask & (mask - 1)) == 0);
            }
        }

        return result;
    }

    int lca(int u, int v) {
        if (depth[u] < depth[v]) {
            int temp = u;
            u = v;
            v = temp;
        }

        int diff = depth[u] - depth[v];

        for (int k = 0; k < LOG; k++) {
            if ((diff & (1 << k)) != 0) {
                u = up[k][u];
            }
        }

        if (u == v) {
            return u;
        }

        for (int k = LOG - 1; k >= 0; k--) {
            if (up[k][u] != up[k][v]) {
                u = up[k][u];
                v = up[k][v];
            }
        }

        return up[0][u];
    }
}
