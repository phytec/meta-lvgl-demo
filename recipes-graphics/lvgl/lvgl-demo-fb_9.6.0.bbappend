FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

PACKAGECONFIG = "wayland"

DEPENDS:append:imxgpu3d = "libdrm virtual/libgbm"

inherit systemd

SRC_URI += "file://lvgl-demo-fb.service \
           "

SYSTEMD_SERVICE:${PN} = "lvgl-demo-fb.service"

FILES:${PN} += "${systemd_unitdir}"

do_install:append() {
    install -Dm 0644 ${UNPACKDIR}/lvgl-demo-fb.service ${D}${systemd_system_unitdir}/lvgl-demo-fb.service
}

