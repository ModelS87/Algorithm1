package pro.sky;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

class StringListImplTest {

  private final IntegerList stringList = new IntegerListImpl();

  @AfterEach
  public void afterEach() {
    stringList.clear();
  }

  @Test
  void addTest() {
    Integer[] elements = {5, 4, 1, 3, 2};
    add(elements);

    for (int i = 0; i < elements.length; i++) {
      assertThat(stringList.get(i)).isEqualTo(elements[i]);
      assertThat(stringList.contains(elements[i])).isTrue();
      assertThat(stringList.indexOf(elements[i])).isEqualTo(i);
      assertThat(stringList.lastIndexOf(elements[i])).isEqualTo(i);
    }

    assertThat(stringList.toArray()).hasSize(elements.length);
    assertThat(stringList.toArray()).containsExactly(elements);
  }

  @Test
  void addByIndexTest() {
    Integer[] elements = {1, 2, 3, 4, 5};
    add(elements);

    stringList.add(0, 6);
    assertThat(stringList.size()).isEqualTo(elements.length + 1);
    assertThat(stringList.get(0)).isEqualTo(6);

    stringList.add(3, 7);
    assertThat(stringList.size()).isEqualTo(elements.length + 2);
    assertThat(stringList.get(3)).isEqualTo(7);
    assertThat(stringList.lastIndexOf(7)).isEqualTo(3);
    assertThat(stringList.indexOf(7)).isEqualTo(3);

    stringList.add(7, 9);
    assertThat(stringList.size()).isEqualTo(elements.length + 3);
    assertThat(stringList.get(7)).isEqualTo(9);
    assertThat(stringList.lastIndexOf(9)).isEqualTo(7);
    assertThat(stringList.indexOf(9)).isEqualTo(7);
  }

  private void add(Integer[] elements) {
    assertThat(stringList.isEmpty()).isTrue();
    Stream.of(elements).forEach(stringList::add);
    assertThat(stringList.size()).isEqualTo(elements.length);
  }

}