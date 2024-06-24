package com.myhome.utils;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
/**
 * Provides a compact representation of page metadata for use in Spring Data applications.
 * It includes current and total pages, as well as the number of elements in each
 * page. The class also provides a factory method for creating new instances based
 * on a pageable object and the corresponding page.
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
     * Generates a `PageInfo` object containing information about the current page of a
     * paginated dataset, including the page number, size, total pages, and total elements.
     * 
     * @param pageable page number and size that the method operates on, providing the
     * necessary context for calculating the resulting page information.
     * 
     * @param page current page being processed, providing information on its position
     * within the paginated data set and the total number of pages and elements available.
     * 
     * @returns a `PageInfo` object containing page number, size, total pages, and total
     * elements.
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
