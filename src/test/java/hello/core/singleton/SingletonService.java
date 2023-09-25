package hello.core.singleton;

public class SingletonService {
    // static 영역에 객체를 딱 한개만 생성
    private static final SingletonService instance = new SingletonService();

    // public으로 열어서 인스턴트가 필요하면 이 static 메소드를 통해서만 조회하도록 허용
    public static SingletonService getInstance() {
        return instance;
    }

    // 생성자를 private로 선언해 생성을 막는다.
    private SingletonService() {
    }

}
