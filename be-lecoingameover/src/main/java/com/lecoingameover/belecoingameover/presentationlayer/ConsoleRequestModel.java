

@Data
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ConsoleRequestModel {

    private String consoleName;
    private LocalDate releaseDate;
    private double price;
    private int quantityInStock;
    private String company;
}