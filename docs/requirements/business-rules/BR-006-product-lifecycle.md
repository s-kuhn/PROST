---
id: BR-006
title: Product Lifecycle
status: accepted
source: Product-owner interviews on 2026-07-26 and 2026-07-27
---

# BR-006: Product Lifecycle

## Rules

1. A Product has a display name, EUR price, active state, whole-number relative column-width weight
   from 1 through 5, and manager-defined print position.
2. A newly created Product is appended to the current print order.
3. An unused Product created by mistake may be deleted.
4. A Product that has appeared on an Issued Tally cannot be deleted.
5. A used Product may be renamed, deactivated, and later reactivated.
6. Renaming or other catalog changes do not alter historical Tally Snapshots.
7. Only active Products appear on a newly issued Tally.
8. There is no business cap on inactive or historical Products.
9. At issuance time, a Tally requires at least one and at most five active Products.
10. All active Products remain on the same horizontal page; Product headers may wrap across lines.
11. The current MVP layout profile uses a 420 mm by 297 mm A3 landscape page. The centerlines of the
    left and right outer Tally-grid lines are each 6 mm from the corresponding page edge; half of
    those lines' strokes may enter the nominal margin. Every other printable element remains at least
    6 mm from every page edge when measured to its nearest printed edge. The top and bottom grid-line
    positions vary with informational content, headings, rows, and pagination. The grid uses a fixed
    51 mm Tally Name column, and the remaining horizontal space is the Product marking area.
12. Relative width weights divide the Product marking area. A rendered Product column, measured
    between the centerlines of its vertical grid lines, must be at least 17 mm wide in the unrounded
    vector layout.
13. The Tally Name column is measured between the centerlines of its vertical grid lines.
14. Product headers start at 12 pt and may shrink to no less than 10 pt after wrapping when necessary
    to fit the A3 landscape page.
15. The complete grid-heading row, including the Tally Name and Product headings, is at least 8.5 mm
    and may expand to at most 25.5 mm when measured between the centerlines of its horizontal grid
    lines. The same rendered height is used wherever the heading repeats.
16. Consumer rows and blank rows are at least 8.5 mm high when measured between the centerlines of
    their horizontal grid lines and are not reduced to fit additional Products or headings.
17. The complete Product display name and price remain visible without clipping or ellipsis.
18. Preview must match the final PDF and allow the Organization Manager to confirm practical marking
    space before issuance.
19. Issuance is blocked when no Product or more than five Products are active, any rendered Product
    column would be narrower than 17 mm, or the complete layout cannot be rendered within the page,
    10 pt minimum Product-header size, and 25.5 mm maximum grid-heading-row height.
20. Physical verification of a vector dimension allows a measurement tolerance of 0.1 mm without
    changing the unrounded layout value that determines validity.

## Future Considerations

- Support for more than five active paper-Tally Products must not require rewriting Settlement or
  account rules. See `QS-MNT-003`.
- The dimensions above are the current MVP acceptance baseline. Pilot evidence may justify a future
  reviewed requirement change and a new layout profile; it does not permit an implementation to vary
  the dimensions silently.
