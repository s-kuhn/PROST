---
title: Licensing And Copyright
status: accepted
source: Product-owner decisions and ownership statements resolving OQ-011 on 2026-07-30
---

# Licensing And Copyright

This policy records the outcome of `OQ-011` and the target licensing state for future releases.

## OQ-011 Resolution

- Original PROST software is to be released under `AGPL-3.0-or-later`.
- Original PROST documentation is to be released under `CC-BY-SA-4.0`.
- Sascha Kuhn is the sole known human copyright owner of original PROST material created from 2025
  onward.
- The current notice is `Copyright © 2025–2026 Sascha Kuhn`.

## License Scope

| Material                                                                                                  | License or treatment                                                                                                 |
|-----------------------------------------------------------------------------------------------------------|----------------------------------------------------------------------------------------------------------------------|
| Original PROST software, tests, API sources, build and deployment definitions, and software configuration | `AGPL-3.0-or-later`                                                                                                  |
| Original PROST documentation, including the root README and original material under `docs/`               | `CC-BY-SA-4.0`                                                                                                       |
| Arc42 template material                                                                                   | `CC-BY-SA-4.0` with the attribution retained in the Arc42 README                                                     |
| Dependencies, tools, fonts, icons, research artifacts, and other third-party material                     | The applicable third-party license; inclusion does not relicense it as PROST material                                |
| Generated files                                                                                           | The license applicable to their source and generation contract; generated files are not edited solely to add notices |

The standard license texts and repository metadata must classify every released file unambiguously
before a release.

## Copyright

The current notice for original copyrightable PROST material is:

```text
Copyright © 2025–2026 Sascha Kuhn
```

Sascha Kuhn is the only known human copyright owner of the original PROST material.

Third-party copyright remains with its respective owners. A name in dependency metadata, development
tooling, or research references does not make that person or organization a PROST copyright owner.

## File-Level Notices

Long license boilerplate is not required in every file. New manually authored source files should
use concise SPDX notices where their format supports comments, for example:

<!-- REUSE-IgnoreStart -->

```text
SPDX-FileCopyrightText: 2025–2026 Sascha Kuhn
SPDX-License-Identifier: AGPL-3.0-or-later
```

<!-- REUSE-IgnoreEnd -->

An IDE template may add these notices as a convenience, but repository-level metadata and automated
verification are authoritative. Before release, `REUSE.toml` or equivalent repository metadata must
classify every tracked file that does not carry an unambiguous inline notice, and an automated
SPDX/REUSE compliance check must pass. Existing generated files, third-party files, binaries, and
versioned Flyway migrations must not be modified merely to add a header.

## Future Contribution Governance

Before accepting the first such contribution, the project must document whether contributors retain
or assign copyright and whether a Developer Certificate of Origin, Contributor License Agreement, or
neither is required. That policy must ensure that submitted software and documentation can be
distributed under their applicable PROST licenses, that contributors have the right to submit
material, and that third-party notices are preserved.

Without an agreement granting broader authority, later relicensing of multi-contributor work may
require every relevant copyright owner's permission.
