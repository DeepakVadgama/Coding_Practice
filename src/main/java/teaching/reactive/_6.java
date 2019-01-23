//package teaching.reactive;
//
//import io.reactivex.Observable;
//
//public class _6 {
//
//    public static void main(String[] args) {
//
//    }
//
//    private void printAllDBChanges() {
//
//        Observable<String> observable = Observable.create(emitter -> {
//            while (true) {
//                // fetch new value from DB
//                emitter.onNext("fetched-value");
//            }
//        });
//        observable.subscribe(System.out::println);
//    }
//}
