package app.test;

import app.main.algo.CompleteGraph;
import app.main.algo.Graph;
import app.main.algo.TSP;
import app.main.algo.TSP1;
import app.main.model.Carte;
import app.main.model.Intersection;
import app.main.model.Segment;

import java.util.*;

public class TestAlgorithmeTSP {
    public static void main(String[] args) {
        double INF = Double.MAX_VALUE;
        double[][] cout = new double[6][6];
        List<Long> etapes = new ArrayList<>();
        etapes.add((long)0);
        etapes.add((long)1);
        etapes.add((long)2);
        etapes.add((long)3);
        etapes.add((long)4);
        etapes.add((long)5);
        TSP tsp = new TSP1();
        // B & B
        Collection<Integer> unvisited = new ArrayList<>(6);
        unvisited.add(1);
        unvisited.add(2);
        unvisited.add(3);
        unvisited.add(4);
        unvisited.add(5);
        cout[0][1] = 4;
        cout[1][0] = 4;
        cout[0][2] = 1;
        cout[2][0] = 1;
        cout[0][3] = INF;
        cout[3][0] = INF;
        cout[0][4] = 3;
        cout[4][0] = 3;
        cout[0][5] = INF;
        cout[5][0] = INF;
        cout[1][2] = 10;
        cout[2][1] = 10;
        cout[1][3] = 1;
        cout[3][1] = 1;
        cout[1][4] = INF;
        cout[4][1] = INF;
        cout[1][5] = INF;
        cout[5][1] = INF;
        cout[2][3] = 5;
        cout[3][2] = 5;
        cout[2][4] = 1;
        cout[4][2] = 1;
        cout[2][5] = INF;
        cout[5][2] = INF;
        cout[3][4] = 3;
        cout[4][3] = 3;
        cout[3][5] = 1;
        cout[5][3] = 1;
        cout[4][5] = 1;
        cout[5][4] = 1;
        cout[0][0] = INF;
        cout[1][1] = INF;
        cout[2][2] = INF;
        cout[3][3] = INF;
        cout[4][4] = INF;
        cout[5][5] = INF;
        System.out.println("Bound 0 : " + ((TSP1) tsp).bound(0, unvisited, cout, etapes.size(), 4));
        System.out.println("Bound 0 : " + ((TSP1) tsp).bound(0, unvisited, cout, etapes.size(), 3));
        //unvisited.remove(3);
        //unvisited.remove(4);
        unvisited.remove(5);
        System.out.println("Bound 1 : " + ((TSP1) tsp).bound(5, unvisited, cout, etapes.size(),4));
        System.out.println("Bound 1 : " + ((TSP1) tsp).bound(5, unvisited, cout, etapes.size(),3));

        // T S P
        System.out.println(new Date(0));
        System.out.println(new Date(8*60*60*1000));
        Intersection intersection0 = new Intersection(0,0,0);
        Intersection intersection1 = new Intersection(1,0,0);
        Intersection intersection2 = new Intersection(2,0,0);
        Intersection intersection3 = new Intersection(3,0,0);
        Intersection intersection4 = new Intersection(4,0,0);
        Intersection intersection5 = new Intersection(5,0,0);
        Map<Long, Intersection> m = new HashMap<>();
        m.put((long)0,intersection0);
        m.put((long)1,intersection1);
        m.put((long)2,intersection2);
        m.put((long)3,intersection3);
        m.put((long)4,intersection4);
        m.put((long)5,intersection5);
        Segment segment0 = new Segment(0,1,null,4);
        Segment segment1 = new Segment(1,0,null,4);
        Segment segment2 = new Segment(0,2,null,1);
        Segment segment3 = new Segment(2,0,null,1);
        Segment segment4 = new Segment(1,2,null,10);
        Segment segment5 = new Segment(2,1,null,10);
        Segment segment6 = new Segment(1,3,null,1);
        Segment segment7 = new Segment(3,1,null,1);
        Segment segment8 = new Segment(2,3,null,5);
        Segment segment9 = new Segment(3,2,null,5);
        Segment segment10 = new Segment(2,4,null,1);
        Segment segment11 = new Segment(4,2,null,1);
        Segment segment12 = new Segment(0,4,null,3);
        Segment segment13 = new Segment(4,0,null,3);
        Segment segment14 = new Segment(4,5,null,1);
        Segment segment15= new Segment(5,4,null,1);
        Segment segment16 = new Segment(3,4,null,3);
        Segment segment17 = new Segment(4,3,null,3);
        Segment segment18 = new Segment(3,5,null,1);
        Segment segment19 = new Segment(5,3,null,1);
        List<Segment> seg = new ArrayList<>();
        seg.add(segment0);
        seg.add(segment1);
        seg.add(segment2);
        seg.add(segment3);
        seg.add(segment4);
        seg.add(segment5);
        seg.add(segment6);
        seg.add(segment7);
        seg.add(segment8);
        seg.add(segment9);
        seg.add(segment10);
        seg.add(segment11);
        seg.add(segment12);
        seg.add(segment13);
        seg.add(segment14);
        seg.add(segment15);
        seg.add(segment16);
        seg.add(segment17);
        seg.add(segment18);
        seg.add(segment19);
        HashMap<Long, Integer> correspondanceIndex = new HashMap<>();
        for (int i = 0; i<etapes.size(); i++){
            correspondanceIndex.put(etapes.get(i), i);
        }
        Carte map = new Carte(m,seg);
        Graph g = new CompleteGraph(etapes, correspondanceIndex, new double[etapes.size()][etapes.size()]);
        g.FillGraph(map);
        long startTime = System.currentTimeMillis();
        tsp.searchSolution(20000, g, g.getCouts());
        System.out.print("Solution of cost "+tsp.getSolutionCost()+" found in "
                +(System.currentTimeMillis() - startTime)+"ms : ");
        for (int i=0; i<etapes.size(); i++)
            System.out.print(tsp.getSolution(i)+" ");
        System.out.println("0");
    }
}