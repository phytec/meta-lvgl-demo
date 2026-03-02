SUMMARY = "LVGL demo application"
DESCRIPTION = "Recipe for a LVGL demo application based on the LVGL widgets demo"
LICENSE = "MIT"
LIC_FILES_CHKSUM = " \
    file://${S}/LICENSE;md5=802d3d83ae80ef5f343050bf96cce3a4 \
"

DEPENDS += " \
    wayland \
    wayland-protocols \
    wayland-native \
    libxkbcommon \
    python3-pcpp-native \
"

SRC_URI = " \
    gitsm://git@github.com/phytec/demo-lvgl;branch=main;protocol=https \
    file://lvgl-demo-wl.service \
"
SRCREV = "b97cd50433e6516d95f8a47570473304ce6110c6"

S = "${WORKDIR}/git"

inherit cmake pkgconfig systemd

SYSTEMD_SERVICE:${PN} = "lvgl-demo-wl.service"

FILES:${PN} += "${systemd_unitdir}"
EXTRA_OECMAKE = "-DSYSROOT=${RECIPE_SYSROOT}"

do_install:append() {
    install -Dm 0644 ${WORKDIR}/lvgl-demo-wl.service ${D}${systemd_system_unitdir}/lvgl-demo-wl.service
}
