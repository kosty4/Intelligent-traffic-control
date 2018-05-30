package simulation;

import backend.Greedy;
import backend.Map;
import backend.Model;
import backend.TrafficLightController;

/**
 * Created by 123 on 31.05.2018.
 */
public class MainController {

    private TrafficLightController trafficLightController;
    private GreedyController greedyController;

    private Map map;
    private Model model;
    private double greenTime;

    private AnimationParts animationParts;

    public MainController(AnimationParts animationParts, int greenTime){

        this.animationParts = animationParts;
        this.map = animationParts.model.map;
        this.model = animationParts.model;
        this.greenTime = greenTime;

        this.trafficLightController = new TrafficLightController(this.animationParts.model.map, this.animationParts.model,
                this.animationParts.model.graph.nodes.get(1),5000,10000);

        this.greedyController = new GreedyController(this.animationParts.model.map,this.animationParts.model,this.animationParts.model.graph.nodes.get(1),
                this.greenTime, this);

    }

    public AnimationParts getAnimationParts(){
        return this.animationParts;
    }

    public TrafficLightController getTLCcontroller(){
        return this.trafficLightController;
    }


}