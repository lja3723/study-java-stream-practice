package problem.medium;

import java.util.List;
import problem.medium.resources.Customer2;
import problem.medium.resources.Employee;
import problem.medium.resources.Order;
import problem.medium.resources.Product;

public class Problem60 {

    /**
     * 주어진 고객(Customer) 리스트와 직원(Employee) 리스트를 사용하여,
     * 'IT' 부서 직원들이 주문한 'Electronics' 제품의 총 가격을 계산합니다.
     * 이때, 고객 이름과 직원 이름이 일치하는 경우에만 해당 고객의 주문을 고려합니다.
     *
     * @param customers 고객 리스트
     * @param employees 직원 리스트
     * @param products 제품 리스트 (제품 이름과 가격 정보 포함)
     * @return 'IT' 부서 직원들이 주문한 'Electronics' 제품의 총 가격
     */
    public static double calculateTotalPriceOfElectronicsOrderedByITEmployees(List<Customer2> customers,
                                                                              List<Employee> employees,
                                                                              List<Product> products) {
        List<String> electronics = List.of("Laptop", "Smartphone");

        // 여기에 코드 작성
        return employees.stream()
                //IT 부서면서 고객인 직원 찾기
                .filter(e -> e.getDepartment().equals("IT"))
                .filter(e -> customers.stream()
                        .anyMatch(c -> c.getName().equals(e.getName())))

                //그 직원들의 주문 리스트 가져오기
                .map(e -> customers.stream()
                        .filter(c -> c.getName().equals(e.getName()))
                        .map(Customer2::getOrders)
                        .findFirst().orElseThrow())

                //리스트 중 Electronics 제품의 가격 합의 리스트 구하기
                .mapToDouble(li -> li.stream()
                        //electonics 분류의 order 구하기
                        .filter(i -> electronics.stream().anyMatch(e -> e.equals(i.getProduct())))

                        //그 order를 가격으로 변환
                        .mapToDouble(i -> i.getQuantity() * products.stream()
                                .filter(p -> p.getName().equals(i.getProduct()))
                                .mapToDouble(p -> p.getPrice())
                                .findAny().getAsDouble())
                        .sum()
                )
                //답 구하기
                .sum();
    }
}
