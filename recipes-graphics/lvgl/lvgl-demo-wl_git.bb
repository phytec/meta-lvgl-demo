SUMMARY = "LVGL demo application"
DESCRIPTION = "Recipe for a LVGL demo application based on the LVGL widgets demo"
LICENSE = "MIT"
LIC_FILES_CHKSUM = " \
    file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302 \
"

DEPENDS += "wayland libxkbcommon"

SRC_URI = " \
    gitsm://git@github.com/phytec/demo-lvgl;branch=main;protocol=https \
"
SRCREV = "be5ee134a6473ca79efd17e212f88a3046796f79"

S = "${WORKDIR}/git"

inherit cmake