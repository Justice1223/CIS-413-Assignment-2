package src;

import java.util.LinkedList;

public class AccountPriorityQueue {
    private LinkedList<Account> queue;

    public AccountPriorityQueue() {
        queue = new LinkedList<>();
    }

    public void addAccount(Account account) {
        if (queue.isEmpty()) {
            queue.add(account);
        } else {
            int i = 0;
            while (i < queue.size() && queue.get(i).compareTo(account) <= 0) {
                i++;
            }
            queue.add(i, account);
        }
    }

    public Account remove() {
        return queue.poll();
    }

    public Account peek() {
        return queue.peek();
    }

    public int size() {
        return queue.size();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("AccountPriorityQueue:\n");
        for (Account account : queue) {
            sb.append(account.toString()).append("\n");
        }
        return sb.toString();
    }
}