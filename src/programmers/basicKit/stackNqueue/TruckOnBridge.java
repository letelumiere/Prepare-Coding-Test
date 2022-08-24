package programmers.basicKit.stackNqueue;
import java.util.*;

class TruckOnBridge {
    public int limitCheck(Queue<Truck> queue, int truck){
        int total = 0;
        for(Truck t : queue) {
            total += t.weight;
        }
        return total+truck;
    }

    public int bridgeShift(Queue<Truck> queue, int bridge_length){
        int result = 0;
        for(Truck t : queue) {
            ++t.location;
        }
        
        Truck t = queue.peek();
        if(t.location>bridge_length){
            queue.poll();
            ++result;
        }
        return result;
    }

    public int solution(int bridge_length, int weight, int[] truck_weights){
        Queue<Truck> bridge = new ArrayDeque<>();

        int time = 0;
        int i = 0;
        int arrived = 0;

        while(true){
            if(arrived==truck_weights.length) break;
            else{
                if(!bridge.isEmpty()) arrived += bridgeShift(bridge, bridge_length);
                if(i<truck_weights.length && limitCheck(bridge, truck_weights[i])<=weight){
                    Truck t = new Truck(truck_weights[i]);
                    ++t.location;
                    bridge.add(t);
                    ++i;
                }
                ++time;
            }
        }
        
        int answer = time;
        return answer;
    }
}

class Truck {
    int weight;
    int location;

    Truck(int weight){
        this.weight = weight;
        this.location = 0;
    }
}