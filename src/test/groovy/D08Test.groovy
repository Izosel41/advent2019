import java.util.stream.Collectors

class D08Test extends GroovyTestCase {

    D08 day = new D08()

    void testCreateLayers() {
        List<List<List<Integer>>> layers = day.createLayers("123456789012", 3, 2)
        assert 2 == layers[0].size()

        assert [1, 2, 3] == layers[0][0]

        assert [4, 5, 6] == layers[0][1]

        assert 2 == layers[1].size()
        assert [7, 8, 9] == layers[1][0]

        assert [0, 1, 2] == layers[1][1]
    }

    void test1() {
        List<List<List<Integer>>> layers = day.createLayers(Util.extractLines("8.txt").get(0), 25, 6)

        Long min = layers
                .stream()
                .mapToLong({
                    layer ->
                        layer.stream().mapToLong({
                            pixels ->
                                pixels.stream()
                                        .filter({ pixel -> pixel == 0 })
                                        .count()
                        }).sum()
                }).min().getAsLong()

        List<Integer> layer = layers
                .stream()
                .filter({
                    it ->
                        it.stream()
                                .find({
                                    pixels ->
                                        min == pixels.stream()
                                                .filter({ pixel -> pixel == 0 })
                                                .count()
                                })
                })

        def one = layer.stream().map({ it -> it.chars().asDoubleStream().filter({ c -> c == 1 }).count() })
        def two = layer.stream().map({ it -> it.chars().asDoubleStream().filter({ c -> c == 2 }).count() })
        println one * two
    }
}
