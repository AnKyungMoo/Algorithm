import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    class Node {
        int[] cArray;

        Node () {
            this.cArray = new int[26];
        }

        Node (int[] cArray) {
            this.cArray = cArray;
        }
    }

    private void solve() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String input = br.readLine();

            int size = 1;
            int length = input.length();

            while (size < length) {
                size <<= 1;
            }

            Node[] tree = new Node[size * 2];

            // 트리 맨 밑
            for (int i = 0, index = size; i < length; ++i, ++index) {
                int[] arr = new int[26];
                arr[input.charAt(i) - 'a']++;
                tree[index] = new Node(arr);
            }
            for (int i = size + length; i < size * 2; ++i) {
                tree[i] = new Node();
            }

            // 트리 위쪽 만들기
            int currIndex = size;
            while (currIndex > 1) {
                for (int i = currIndex; i < currIndex * 2; i += 2) {
                    int[] arr = new int[26];
                    for (int j = 0; j < 26; ++j) {
                        arr[j] += tree[i].cArray[j];
                        arr[j] += tree[i + 1].cArray[j];
                    }

                    tree[i / 2] = new Node(arr);
                }

                currIndex /= 2;
            }

            int N = Integer.parseInt(br.readLine());

            String[] s;
            for (int i = 0; i < N; ++i) {
                s = br.readLine().split(" ");
                int a = Integer.parseInt(s[0]);
                int b = Integer.parseInt(s[1]);

                if (a == 1) {
                    // 바꾸기
                    int tempIndex = b + size - 1;

                    Arrays.fill(tree[tempIndex].cArray, 0);
                    tree[tempIndex].cArray[s[2].charAt(0) - 'a']++;

                    while (tempIndex > 1) {
                        if (tempIndex % 2 == 0) {
                            for (int k = 0; k < 26; ++k) {
                                int count = 0;
                                count += tree[tempIndex].cArray[k];
                                count += tree[tempIndex + 1].cArray[k];
                                tree[tempIndex / 2].cArray[k] = count;
                            }
                        } else {
                            for (int k = 0; k < 26; ++k) {
                                int count = 0;
                                count += tree[tempIndex].cArray[k];
                                count += tree[tempIndex - 1].cArray[k];
                                tree[tempIndex / 2].cArray[k] = count;
                            }
                        }

                        tempIndex /= 2;
                    }

                } else if (a == 2) {
                    // 출력하기
                    int c = Integer.parseInt(s[2]);
                    int[] arr = new int[26];

                    int left = b + size - 1;
                    int right = c + size - 1;

                    while (left < right) {
                        if (left % 2 == 1) {
                            for (int k = 0; k < 26; ++k) {
                                arr[k] += tree[left].cArray[k];
                            }
                            left++;
                        }

                        if (right % 2 == 0) {
                            for (int k = 0; k < 26; ++k) {
                                arr[k] += tree[right].cArray[k];
                            }
                            right--;
                        }

                        left /= 2;
                        right /= 2;
                    }

                    if (left == right) {
                        for (int k = 0; k < 26; ++k) {
                            arr[k] += tree[left].cArray[k];
                        }
                    }

                    int result = 0;
                    for (int k = 0; k < 26; ++k) {
                        if (arr[k] != 0) {
                            result++;
                        }
                    }

                    System.out.println(result);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Main().solve();
    }
}