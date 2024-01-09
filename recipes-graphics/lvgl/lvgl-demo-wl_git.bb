SUMMARY = "LVGL demo application"
DESCRIPTION = "Recipe for a LVGL demo application based on the LVGL widgets demo"
LICENSE = "MIT"
LIC_FILES_CHKSUM = " \
    file://${S}/LICENSE;md5=802d3d83ae80ef5f343050bf96cce3a4 \
"

DEPENDS += "wayland libxkbcommon"

SRC_URI = " \
    gitsm://git@github.com/phytec/demo-lvgl;branch=main;protocol=https \
    file://lvgl-demo-wl.service \
"
SRCREV = "be5ee134a6473ca79efd17e212f88a3046796f79"

S = "${WORKDIR}/git"

inherit cmake systemd

SYSTEMD_SERVICE:${PN} = "lvgl-demo-wl.service"

FILES:${PN} += "${systemd_unitdir}"

do_install:append() {
    install -Dm 0644 ${WORKDIR}/lvgl-demo-wl.service ${D}${systemd_system_unitdir}/lvgl-demo-wl.service
}
