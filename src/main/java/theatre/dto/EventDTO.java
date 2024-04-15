package theatre.dto;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import theatre.util.SourceType;

public class EventDTO {

    private long id;
    private String title;
    private final long promoterId;
    private final long minPrice;
    private final String shortUrl;
    private final String shortImageUrl;
    private final String specialStatus;
    private final String venueDescription;
    private final String salesStatus;
    private final String localisedStartDate;
    private final String localisedEndDate;
    private final String prices;
    private final String type;
    private final String salestart;
    @Enumerated(EnumType.STRING)
    private final SourceType source;

    public EventDTO(long id, String title, long promoterId, long minPrice, String shortUrl, String shortImageUrl, String specialStatus, String venueDescription, String salesStatus, String localisedStartDate, String localisedEndDate, String prices, String type, String salestart, SourceType source) {
        this.id = id;
        this.title = title;
        this.promoterId = promoterId;
        this.minPrice = minPrice;
        this.shortUrl = shortUrl;
        this.shortImageUrl = shortImageUrl;
        this.specialStatus = specialStatus;
        this.venueDescription = venueDescription;
        this.salesStatus = salesStatus;
        this.localisedStartDate = localisedStartDate;
        this.localisedEndDate = localisedEndDate;
        this.prices = prices;
        this.type = type;
        this.salestart = salestart;
        this.source = source;
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public long getPromoterId() {
        return promoterId;
    }
    public long getMinPrice() {
        return minPrice;
    }
    public String getShortUrl() {
        return shortUrl;
    }
    public String getShortImageUrl() {
        return shortImageUrl;
    }
    public String getSpecialStatus() {
        return specialStatus;
    }
    public String getVenueDescription() {
        return venueDescription;
    }
    public String getSalesStatus() {
        return salesStatus;
    }
    public String getLocalisedStartDate() {
        return localisedStartDate;
    }
    public String getLocalisedEndDate() {
        return localisedEndDate;
    }
    public String getPrices() {
        return prices;
    }
    public String getType() {
        return type;
    }
    public String getSalestart() {
        return salestart;
    }

}