package com.myhome.utils;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Represents pagination data of a page. It is designed to hold essential information
 * about the current page such as its number and total elements. The class provides
 * a static factory method to create instances from Spring's Pageable and Page objects.
 */
@EqualsAndHashCode
@ToString
@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class PageInfo {
  private final int currentPage;
  private final int pageLimit;
  private final int totalPages;
  private final long totalElements;
    /**
     * Returns a new `PageInfo` object populated with data from the provided `Pageable`
     * and `Page`. It extracts page number, page size, total pages, and total elements
     * from these objects to initialize the `PageInfo` instance.
     * 
     * @param pageable pagination information for retrieving data, providing the current
     * page number and page size.
     * 
     * @param page Page object that contains the total number of pages and elements, which
     * is used to construct the PageInfo object.
     * 
     * @returns a `PageInfo` object containing pagination details.
     */
    public static PageInfo of(Pageable pageable, Page<?> page) {
    return new PageInfo(
        pageable.getPageNumber(),
        pageable.getPageSize(),
        page.getTotalPages(),
        page.getTotalElements()
    );
  }
}
