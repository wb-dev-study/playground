package jay.coordinate.views;

public class Output {
    private static final String STRAIGHT = "두 점 사이 거리는 ";
    private static final String QUADRANGLE = "사각형 넓이는 ";
    private static final String TRIANGLE = "삼각형 넓이는 ";

    public static void straightLineResultMessage(Double result){
        System.out.println(STRAIGHT + result);
    }

    public static void quadrangleResultMessage(Double result) {
        System.out.println(QUADRANGLE + result);
    }

    public static void triangleResultMessage(Double result) {
        System.out.println(TRIANGLE + result);
    }
}
