const BEGIN_WEEK =
`
<div class="row w-auto bg-dark rounded bg-opacity-25 mb-2 mt-2 pt-2 pb-2">
`;

const END_WEEK =
`
</div>
`;

const EMPTY_DAY =
`
<div class="col-md text-center">
    <button disabled class="w-100 btn mb-1 btn-outline-dark rounded" type="button" data-bs-toggle="collapse"
        data-bs-target="#__DAY____WEEK_LEVEL__" aria-expanded="false" aria-controls="__DAY____WEEK_LEVEL__">
        <b>__NAME__</b><br> Diciembre
    </button>
    <div class="collapse mb-1 rounded" id="__DAY____WEEK_LEVEL__">
        <div class="card-body text-center">

        </div>
    </div>
</div>
`;

const EVENT =
`
<div class="rounded __EVENT_COLOR__ mb-1 mt-1">
<embed class="embed-pos" src="../assets/clock.svg" /> __TIME__
</div>

<div class="rounded event-details-bg p-2">
    __EVENT_MESSAGE__
</div>
`;

const BEGIN_DAY =
`
<div class="col-md text-center">
    <button class="w-100 btn btn-light __MONTH_COLOR__ mb-1 rounded" 
                   type="button"
                   data-bs-toggle="collapse" 
                   data-bs-target="#__WEEK_DAY_TARGET__" 
                   aria-expanded="false" 
                   aria-controls="__WEEK_DAY_TARGET__">
        <b>__NAME__</b><br> __DATE__ <br> __HAS_EVENTS__
    </button>

    <div class="collapse mb-1 rounded" id="__WEEK_DAY_TARGET__">
        <div class="card-body text-center rounded">
`;

const END_DAY =
`
        </div>
    </div>
</div>
`;

const LINK =
`
<li class="list-group-item">
    <a class="link-dark link-offset-1 link-underline link-underline-opacity-0 link-opacity-50-hover" href="__LINK__">
        Calendario del año __YEAR__
    </a>
</li>
`;


const BEGIN_YEAR = 
`
<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="styles.css">
    <title>__CALENDAR_TITLE__</title>

    <style>
        __STYLES__
    </style>
</head>

<body>
<nav class="navbar nav-bar-color">
        <div class="container-fluid">
            <button class="navbar-toggler" type="button" data-bs-toggle="offcanvas" data-bs-target="#offcanvasNavbar"
                aria-controls="offcanvasNavbar" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <h1 class="navbar-brand">Calendario del año __CALENDAR_TITLE__ </h1>
            <img src="../assets/Logo.png" id="logo-iesv">
            <div class="offcanvas offcanvas-start" tabindex="-1" id="offcanvasNavbar"
                aria-labelledby="offcanvasNavbarLabel">
                <div class="offcanvas-header bg-dark-subtle">
                    <h5 class="offcanvas-title" id="offcanvasNavbarLabel">Calendarios</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="offcanvas" aria-label="Close"></button>
                </div>

                <!-- Cuerpo del offcanvas-->
                <div class="offcanvas-body">
                    <!-- Aquí añadimos anclas a los demás anños si los hay -->
                    <ul class="list-group list-group-flush">
                        __CALENDARS__
                    </ul>
                </div>

            </div>
        </div>
    </nav>

    <div class="container-fluid container-adjusted">
`;

const BOTTOM_LINK_ACTIVE =
`
<li class="page-item active" aria-current="page">
    <a class="page-link" href="__LINK__">Calendario __YEAR__</a>
</li>
`;

const BOTTOM_LINK = 
`
<li class="page-item">
    <a class="page-link" href="__LINK__">Calendario __YEAR__</a>
</li>
`;

const END_YEAR = 
`   
    <div class="row">
        <nav class"text-center" aria-label="Avance calendarios">
            <ul class="pagination">
            <li class="page-item__DISABLE_PREV__">
                <a class="page-link" href="__LINK_PREV__">Anterior</a>
            </li>

                __BOTTOM_LINKS__

            <li class="page-item__DISABLE_NEXT__">
                <a class="page-link" href="__LINK_NEXT__">Siguiente</a>
            </li>
        </ul>
        </nav>
    </div>

    </div>

    <script>__SCRIPT__</script>
</body>

</html>
`;

exports.BEGIN_WEEK = BEGIN_WEEK;
exports.END_WEEK = END_WEEK;
exports.EMPTY_DAY = EMPTY_DAY;
exports.EVENT = EVENT;
exports.BEGIN_DAY = BEGIN_DAY;
exports.END_DAY = END_DAY;
exports.BEGIN_YEAR = BEGIN_YEAR;
exports.END_YEAR = END_YEAR;
exports.LINK = LINK;
exports.BOTTOM_LINK = BOTTOM_LINK;
exports.BOTTOM_LINK_ACTIVE = BOTTOM_LINK_ACTIVE;