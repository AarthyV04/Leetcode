class TaskManager {
    private static class Task {
        int userId;
        int taskId;
        int priority;

        Task(int userId, int taskId, int priority) {
            this.userId = userId;
            this.taskId = taskId;
            this.priority = priority;
        }
    }
    private Map<Integer, Task> taskMap;
    private TreeSet<Task> taskSet;
    public TaskManager(List<List<Integer>> tasks) {
        taskMap = new HashMap<>();
        taskSet = new TreeSet<>((a, b) -> {
            if (a.priority != b.priority) {
                return Integer.compare(b.priority, a.priority);  // higher priority first
            } else {
                return Integer.compare(b.taskId, a.taskId);  // higher taskId first
            }
        });

        for (List<Integer> t : tasks) {
            int userId = t.get(0);
            int taskId = t.get(1);
            int priority = t.get(2);
            add(userId, taskId, priority);
        }
    }
    public void add(int userId, int taskId, int priority) {
        Task task = new Task(userId, taskId, priority);
        taskMap.put(taskId, task);
        taskSet.add(task);
    }
    
    public void edit(int taskId, int newPriority) {
        Task old = taskMap.get(taskId);
        if (old == null) return;  
        taskSet.remove(old);
        Task updated = new Task(old.userId, taskId, newPriority);
        taskMap.put(taskId, updated);
        taskSet.add(updated);
    }
    
    public void rmv(int taskId) {
        Task t = taskMap.remove(taskId);
        if (t == null) return;  
        taskSet.remove(t);
    }
    
    public int execTop() {
        if (taskSet.isEmpty()) return -1;
        Task top = taskSet.first();  
        taskSet.remove(top);
        taskMap.remove(top.taskId);
        return top.userId;
    }
}

/**
 * Your TaskManager object will be instantiated and called as such:
 * TaskManager obj = new TaskManager(tasks);
 * obj.add(userId,taskId,priority);
 * obj.edit(taskId,newPriority);
 * obj.rmv(taskId);
 * int param_4 = obj.execTop();
 */