class Solution {
    public static String simplifyPath(String path) {
        Deque<String> stack = new ArrayDeque<>();
                String[] parts = path.split("/+");
        for (String part : parts) {
            if (part.equals("") || part.equals(".")) {
                continue;
            } else if (part.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(part);
            }
        }
        StringBuilder sb = new StringBuilder();
        if (stack.isEmpty()) {
            return "/";
        }
        while (!stack.isEmpty()) {
            sb.insert(0, "/" + stack.removeFirst());
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        System.out.println(simplifyPath("/home/"));                  
        System.out.println(simplifyPath("/home//foo/"));             
        System.out.println(simplifyPath("/home/user/Documents/../Pictures")); 
        System.out.println(simplifyPath("/../"));                    
        System.out.println(simplifyPath("/.../a/../b/c/../d/./")); 
    }
}