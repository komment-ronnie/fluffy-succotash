package com.myhome.utils;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Is a data structure used to represent information about a page of elements. It
 * consists of four fields: currentPage, pageLimit, totalPages, and totalElements.
 * The class provides a convenient way to create instances of PageInfo from a Pageable
 * object and its corresponding Page.
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
     * Takes a `pageable` and a `page` object as input, returning a `PageInfo` object
     * containing information about the page number, size, total pages, and total elements.
     * 
     * @param pageable Pageable object that contains information about the current page
     * of data being processed, providing the number of elements per page and the total
     * number of elements in the result set.
     * 
     * @param page current page being processed, providing information on its position
     * and size within the overall result set.
     * 
     * @returns a `PageInfo` object containing information about the page number, size,
     * total pages, and total elements of the pageable.
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
