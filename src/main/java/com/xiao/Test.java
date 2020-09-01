package com.xiao;

import com.xiao.Zero.UserType;
import sun.misc.BASE64Encoder;

import java.io.ByteArrayOutputStream;
import java.lang.reflect.Method;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.*;


public class Test {

    private static void Accept(doinbi str) {
        str.setNumber("12312");
        str.setType(UserType.一般会员);
        System.out.println("print value" + str);
    }

    public static String encryptMessage(String msg) {
        String retVal = "";
        try {
            SecureRandom random = new SecureRandom();
            byte[] salt = new byte[8];
            random.nextBytes(salt);
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(salt);
            md.update(msg.getBytes());
            byte[] digestBytes = md.digest();
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            baos.write(salt);
            baos.write(digestBytes);
            byte[] aa = baos.toByteArray();
            BASE64Encoder encoder = new BASE64Encoder();
            retVal = encoder.encode(aa);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return retVal;
    }


    private static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = 0;
        for (int i : candies) {
            max = Math.max(max, i);
        }
        List<Boolean> list = new ArrayList<>();
        for (int i : candies) {
            if (i >= (max - extraCandies)) {
                list.add(true);
            } else {
                list.add(false);
            }
        }
        return list;
    }


    private static int xorOperation(int n, int start) {
        int res = 0;
        for (int i = 0; i < n; i++) {
            res = res ^ (start + 2 * i);
        }
        return res;
    }

    public int numTeams(int[] rating) {
        int res = 0;
        if (rating.length < 3) {
            return 0;
        } else {
            for (int i = 1; i < rating.length - 1; i++) {

            }
        }
        return res;
    }

    public int[] shuffle(int[] nums, int n) {
        int[] res = new int[2 * n];
        int k = 0;
        for (int i = 0; i < n; i++) {
            res[k] = nums[i];
            k++;
            res[k] = nums[n + i];
            k++;
        }
        return res;
    }

    public int game(int[] guess, int[] answer) {
        int res = 0;
        for (int i = 0; i < guess.length; i++) {
            if (guess[i] == answer[i])
                res++;
        }
        return res;
    }

    public int[] intersect(int[] nums1, int[] nums2) {
        int a = nums1.length > nums2.length ? nums1.length : nums2.length;
        int[] res = new int[a];
        int j = 0;
        for (int i : nums1) {
            if (Arrays.binarySearch(nums2, i) > 0) {
                res[j] = i;
                j++;
            }
        }
        return res;
    }

    public static int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int dp[][] = new int[n][n];
        List<Integer> list = triangle.get(n - 1);
        for (int i = 0; i < n; ++i) {
            dp[n - 1][i] = list.get(i);
        }
        for (int i = n - 2; i >= 0; --i) {
            List<Integer> raw = triangle.get(i);
            for (int j = 0; j < i + 1; ++j) {
                dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + raw.get(j);
            }

        }
        return dp[0][0];
    }

    public static List removesame(List list) {
        HashSet set = new HashSet(list);
        list.clear();
        list.addAll(set);
        return list;
    }

    public int searchInsert(int[] nums, int target) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= target) {
                res = i + 1;
            }
            if (nums[i] == target) {
                res = i;
            }
        }
        return res;
    }

    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        } else if (x == 0) {
            return true;
        }
        String str = String.valueOf(x);
        String res = new StringBuffer(str).reverse().toString();
        if (str.equals(res)) {
            return true;
        } else {
            return false;
        }
    }

    public static String longestCommonPrefix(String[] strs) {
        String mod = strs[0];
        int index = 0;
        for (int i = 1; i < strs.length; i++) {
            int k = 0;
            int v = 0;
            if (strs[i].length() < mod.length()) {
                v = strs[i].length();
            }
            String c = strs[i];
            for (int j = 0; j < v; j++) {
                if (mod.charAt(j) == c.charAt(j)) {
                    k = j;
                }
            }
            if (index < k) {
                index = k + 1;
            }
        }
        return mod.substring(0, index);
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int temp = target - nums[i];
            if (map.containsKey(temp)) {
                return new int[]{map.get(temp), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("can find");
    }

    public int searchNum(int[] nums, int res) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (right + left) / 2;
            if (nums[mid] == res) return mid;
            else if (nums[mid] > res) right = mid - 1;
            else if (nums[mid] < res) left = mid + 1;
        }
        return -1;
    }

    public int minArray(int[] numbers) {
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (numbers[mid] > numbers[right])
                left = mid + 1;
            else if (numbers[mid] < numbers[right])
                right = mid;
            else right--;
        }
        return numbers[right];
    }

    public static int lengthOfLastWord(String s) {
        int res = 0;
        if (s.length() == 0 || s == null) return 0;
        else {
            if (s.charAt((s.length() - 1)) == ' ') return 0;
            else {
                for (int i = s.length() - 1; i >= 0; --i) {
                    char temp = s.charAt(i);
                    if (temp == ' ') break;
                    res++;
                }
            }
        }
        return res;
    }

    public int maxProduct(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length-1]*nums[nums.length-2]-nums[nums.length-1]-nums[nums.length-2]+1;
    }

    public int[] replaceElements(int[] arr) {
        int[] brr = new int[arr.length - 1];
        int temp = 0;
        int j = 0;
        for (int i = arr.length - 1; i > 0; i--) {
            if (arr[i] > temp) {
                temp = arr[i];
            }
            brr[j] = temp;
            j++;
        }
        j = arr.length - 2;
        for (int i = 0; i < arr.length - 1; i++) {
            arr[i] = brr[j];
            j--;
        }
        arr[arr.length - 1] = -1;
        return arr;
    }

    public static int[] printNumbers(int n) {
        int temp = (int) (Math.pow(10,n)-1);
        int[] res = new int[temp];
        for (int i = 0;i<temp;i++){
            res[i]=i+1;
        }
        return res;
    }

    public String restoreString(String s, int[] indices) {
        char[] res=new char[indices.length];
        for(int i=indices.length-1;i>-1;i--){
            res[indices[i]]=s.charAt(i);
        }
        return String.valueOf(res);
    }


    public static void main(String[] args) {

        System.out.println(doinbi.class);
        doinbi doi = new doinbi();
        System.out.println(doi.getClass());
        System.out.println(doinbi.class.getName());
        List<doinbi> list = new ArrayList<>();
        Map<String, doinbi> map = new HashMap<>();
        for (int i = 0; i < 5; i++) {
            doinbi doin = new doinbi();
            doin.setName("hello" + i);
            doin.setAge(i);
            list.add(doin);
        }
        list.forEach(x -> {
            System.out.println(x.toString());
            map.put(x.getName(), x);
        });
        System.out.println("====================");

        list.forEach(Test::Accept);
        System.out.println("====================");
        for (doinbi d : list) {
            System.out.println(d);
        }
        System.out.println(map);


        int[] c = {2, 3, 5, 1, 3};
        List<Boolean> list1 = Test.kidsWithCandies(c, 1);
        System.out.println(list1);


        String s = new doinbi() {
            String prints() {
                super.printsomething();
                return "nmsl";
            }
        }.prints();
        System.out.println(s);

        List<List<Integer>> triangle = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        list2.add(2);
        List<Integer> list3 = new ArrayList<>();
        list3.add(3);
        list3.add(4);
        List<Integer> list4 = new ArrayList<>();
        list4.add(6);
        list4.add(5);
        list4.add(7);
        List<Integer> list5 = new ArrayList<>();
        list5.add(4);
        list5.add(1);
        list5.add(8);
        list5.add(3);
        triangle.add(list2);
        triangle.add(list3);
        triangle.add(list4);
        triangle.add(list5);
        int j = minimumTotal(triangle);
        System.out.println(j);

        List set = new ArrayList();
        set.add("1");
        set.add("2");
        set.add("1");
        set.add("2");
        set.add("3");
        List list6 = removesame(set);
        System.out.println(list6);


        boolean b = isPalindrome(121);
        System.out.println(b);

        String[] lo = {"float", "ftte", "flo"};
        String ddd = longestCommonPrefix(lo);
        System.out.println(ddd);

        String MD5 = encryptMessage("12345679");
        System.out.println("12345679:" + MD5);

        int lastncount = lengthOfLastWord("hello world");
        System.out.println("====" + lastncount);


        try {
            Class<?> clasz = Class.forName("com.xiao.Utils.EmptyUtil");
            Method method = clasz.getMethod("isEmpty",String.class,String.class);
            method.invoke(clasz.newInstance(),"","hello");

        } catch (Exception e) {
            e.printStackTrace();
        }


        System.out.println("+++"+printNumbers(1));

    }

    public int[] runningSum(int[] nums) {
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                result[0] = nums[0];
            } else {
                result[i] = nums[i] + result[i - 1];
            }
        }
        return result;
    }

}
