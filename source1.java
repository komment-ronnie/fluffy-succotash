package com.myhome.utils;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Encapsulates information about pages in a dataset, including current page number,
 * page size, total pages, and total elements. It provides a static factory method
 * to create an instance based on Pageable and Page objects. The class is designed
 * to facilitate pagination and provide relevant data for handling page-based operations.
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
     * Initializes a `PageInfo` object with data retrieved from a `pageable` and a `page`
     * instance. It sets the page number, page size, total pages, and total elements. The
     * resulting `PageInfo` object is returned.
     * 
     * @param pageable pagination metadata, providing information about the current page
     * number and size of the data being paginated.
     * 
     * @param page pagination information of the data, providing details such as total
     * pages and total elements.
     * 
     * @returns an instance of `PageInfo`, containing pagination metadata.
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
