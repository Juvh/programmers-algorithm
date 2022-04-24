package juv.study.algorithm.programmers.dfsbfs;

import java.util.*;

public class TravelRoute {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.solution(new String[][]{{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}})));
        System.out.println(Arrays.toString(solution.solution(new String[][]{{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}})));
    }


    static class Solution {

        public static final int START_INDEX = 0;
        public static final int END_INDEX = 1;
        public static final String FIRST_STARTING_POINT = "ICN";
        
        private Map<String, List<Ticket>> ticketByStart;
        private int ticketCount;

        public String[] solution(String[][] tickets) {
            ticketByStart = makeTicketMapByStart(tickets);
            ticketCount = tickets.length;

            boolean[] used = new boolean[tickets.length];
            int visited = 0;
            return traverse(FIRST_STARTING_POINT, visited, used).toArray(new String[0]);
        }
        
        private List<String> traverse(String start, int visited, boolean[] used) {
            List<String> route = new ArrayList<>();
            route.add(start);
            int remainTicketCount = ticketCount - visited - 1;
            if (remainTicketCount >= ticketCount) {
                return route;
            }
            
            boolean[] newUsed = Arrays.copyOf(used, used.length);

            List<Ticket> ticketList = ticketByStart.get(start);
            if (ticketList == null) {
                return route;
            }
            ticketList.sort(Comparator.comparing(o -> o.end));
            for (Ticket ticket : ticketList) {
                // 방문했으면 skip
                if (newUsed[ticket.idx]) {
                    continue;
                }
                newUsed[ticket.idx] = true;
                List<String> nextRoutes = traverse(ticket.end, ticketCount - remainTicketCount, newUsed);
                if (nextRoutes.size() + visited == ticketCount) {
                    route.addAll(nextRoutes);
                    return route;
                }
                newUsed[ticket.idx] = false;
            }
            return route;
        }

        private Map<String, List<Ticket>> makeTicketMapByStart(String[][] tickets) {
            Map<String, List<Ticket>> ticketByStart = new HashMap<>();

            for (int i = 0; i < tickets.length; i++) {
                String start = tickets[i][START_INDEX];
                List<Ticket> value = ticketByStart.getOrDefault(start, new ArrayList<>());
                value.add(new Ticket(i, start, tickets[i][END_INDEX]));
                ticketByStart.put(start, value);
            }
            return ticketByStart;
        }

        class Ticket {
            int idx;
            String start;
            String end;

            public Ticket(int idx, String start, String end) {
                this.idx = idx;
                this.start = start;
                this.end = end;
            }
        }
    }
}
