package com.nadharia.news_compose

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.materialIcon
import androidx.compose.material.icons.materialPath
import androidx.compose.ui.graphics.vector.ImageVector

public val Icons.Filled.Source: ImageVector
    get() {
        if (_databaseDocument != null) {
            return _databaseDocument!!
        }
        _databaseDocument = materialIcon(name = "Filled.DatabaseDocument") {
            materialPath {
                // Database - Cylindrical Top
                moveTo(8.0f, 4.0f)
                curveToRelative(4.0f, 0.0f, 8.0f, 1.5f, 8.0f, 3.0f)
                reflectiveCurveToRelative(-4.0f, 3.0f, -8.0f, 3.0f)
                reflectiveCurveToRelative(-8.0f, -1.5f, -8.0f, -3.0f)
                reflectiveCurveToRelative(4.0f, -3.0f, 8.0f, -3.0f)
                close()
            }
            materialPath {
                // Database - Middle Layers
                moveTo(8.0f, 10.0f)
                curveToRelative(4.0f, 0.0f, 8.0f, -1.5f, 8.0f, -3.0f)
                verticalLineToRelative(3.0f)
                curveToRelative(0.0f, 1.5f, -4.0f, 3.0f, -8.0f, 3.0f)
                reflectiveCurveToRelative(-8.0f, -1.5f, -8.0f, -3.0f)
                verticalLineToRelative(-3.0f)
                curveToRelative(0.0f, 1.5f, 4.0f, 3.0f, 8.0f, 3.0f)
                close()
            }
            materialPath {
                // Database - Bottom Layer
                moveTo(8.0f, 14.0f)
                curveToRelative(4.0f, 0.0f, 8.0f, -1.5f, 8.0f, -3.0f)
                verticalLineToRelative(3.0f)
                curveToRelative(0.0f, 1.5f, -4.0f, 3.0f, -8.0f, 3.0f)
                reflectiveCurveToRelative(-8.0f, -1.5f, -8.0f, -3.0f)
                verticalLineToRelative(-3.0f)
                curveToRelative(0.0f, 1.5f, 4.0f, 3.0f, 8.0f, 3.0f)
                close()
            }
            materialPath {
                // Small Dots (Representing Data)
                moveTo(5.0f, 16.5f)

                moveTo(7.0f, 16.5f)

                moveTo(9.0f, 16.5f)

            }
            materialPath {
                // Document Shape
                moveTo(14.0f, 10.0f)
                lineTo(14.0f, 18.0f)
                horizontalLineToRelative(6.0f)
                verticalLineToRelative(-8.0f)
                close()
            }
            materialPath {
                // Document Fold
                moveTo(20.0f, 10.0f)
                lineTo(17.5f, 7.5f)
                horizontalLineToRelative(-3.5f)
            }
            materialPath {
                // Document Text Lines
                moveTo(15.0f, 12.0f)
                horizontalLineToRelative(3.0f)
                moveTo(15.0f, 14.0f)
                horizontalLineToRelative(3.0f)
                moveTo(15.0f, 16.0f)
                horizontalLineToRelative(3.0f)
            }
        }
        return _databaseDocument!!
    }

private var _databaseDocument: ImageVector? = null
