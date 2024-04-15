package theatre.service;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import theatre.dto.EventDTO;
import theatre.dto.Response;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class KvitkiWebClient {
    public KvitkiWebClient(WebClient kvitkiWebClient) {
        KvitkiWebClient = kvitkiWebClient;
    }
    private final WebClient KvitkiWebClient;

    public List<EventDTO> getEvents(){
        AtomicInteger pageNumber = new AtomicInteger(1);
        return getEvents(pageNumber.get())
                .expand(expand -> {
                    if(pageNumber.get() > 10){
                        return Mono.empty();
                    }
                    Mono<List<EventDTO>> events = getEvents(pageNumber.get());
                    pageNumber.incrementAndGet();
                    return events;
                })
                .flatMap(Flux::fromIterable)
                .distinct()
                .collectList()
                .block();
    }

    private Mono<List<EventDTO>> getEvents(Integer pageId){
        return  KvitkiWebClient
                .get()
                .uri("https://www.kvitki.by/ajaxCaller/method:getConcertsListInfo/id:1003/type:catalog_category/page:{pageId}/design:kvitki/portal:2/?fields%5Bevent%5D=id,title,promoterId,minPrice,decoratedTitle,discount,shortUrl,shortImageUrl,specialStatus,venueDescription,salesStatus,localisedStartDate,localisedEndDate,startTime,endTime,centerId,prices,buyButtonConfig,badgeData,type,customTargetUrl,subMode,decoratedShortContent,salestart,countryCode", pageId)
                .retrieve()
                .bodyToMono(Response.class)
                .map(responseData -> responseData.getResponseData().getEvent());
    }
}
