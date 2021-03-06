package io.sparkled.model.validator

import io.sparkled.model.entity.StageProp
import io.sparkled.model.validator.exception.EntityValidationException

class StagePropValidator {

    fun validate(stageProps: List<StageProp>) {
        checkForDuplicates(stageProps)
        stageProps.forEach(this::validateStageProp)
    }

    private fun checkForDuplicates(stageProps: List<StageProp>) {
        val stagePropCodes = stageProps.asSequence().map(StageProp::getCode).toList()
        val duplicateCodes = ValidatorUtils.findDuplicates(stagePropCodes)

        if (!duplicateCodes.isEmpty()) {
            val duplicateCodeList = duplicateCodes.joinToString(", ")
            throw EntityValidationException(String.format(Errors.DUPLICATES_FOUND, duplicateCodeList))
        }
    }

    private fun validateStageProp(stageProp: StageProp) {
        if (stageProp.getUuid() == null) {
            throw EntityValidationException(Errors.UUID_MISSING)
        } else if (stageProp.getStageId() == null) {
            throw EntityValidationException(Errors.STAGE_ID_MISSING)
        } else if (stageProp.getCode() == null) {
            throw EntityValidationException(Errors.CODE_MISSING)
        } else if (stageProp.getName() == null) {
            throw EntityValidationException(Errors.NAME_MISSING)
        } else if (stageProp.getType() == null) {
            throw EntityValidationException(Errors.TYPE_MISSING)
        } else if (stageProp.getLedCount() == null || stageProp.getLedCount()!! < 0) {
            throw EntityValidationException(Errors.LED_COUNT_NEGATIVE)
        } else if (stageProp.getPositionX() == null) {
            throw EntityValidationException(Errors.POSITION_X_MISSING)
        } else if (stageProp.getPositionY() == null) {
            throw EntityValidationException(Errors.POSITION_Y_MISSING)
        } else if (stageProp.getPositionX() == null) {
            throw EntityValidationException(Errors.SCALE_X_MISSING)
        } else if (stageProp.getPositionY() == null) {
            throw EntityValidationException(Errors.SCALE_Y_MISSING)
        } else if (stageProp.getRotation() == null || stageProp.getRotation()!! < -180 || stageProp.getRotation()!! > 180) {
            throw EntityValidationException(Errors.ROTATION_INVALID)
        } else if (stageProp.getBrightness() == null || stageProp.getBrightness()!! < 0 || stageProp.getBrightness()!! > 100) {
            throw EntityValidationException(Errors.BRIGHTNESS_INVALID)
        } else if (stageProp.getDisplayOrder() == null) {
            throw EntityValidationException(Errors.DISPLAY_ORDER_MISSING)
        }
    }

    private object Errors {
        internal const val DUPLICATES_FOUND = "Duplicate stage prop code(s) (%s) are not allowed."
        internal const val UUID_MISSING = "Stage prop has no unique identifier."
        internal const val STAGE_ID_MISSING = "Stage prop has no stage identifier."
        internal const val CODE_MISSING = "Stage prop code must not be empty."
        internal const val NAME_MISSING = "Stage prop name must not be empty."
        internal const val TYPE_MISSING = "Stage prop type must not be empty."
        internal const val LED_COUNT_NEGATIVE = "Stage prop LED count must be non-negative."
        internal const val POSITION_X_MISSING = "Stage prop X position must not be empty."
        internal const val POSITION_Y_MISSING = "Stage prop X position must not be empty."
        internal const val SCALE_X_MISSING = "Stage prop X scale must not be empty."
        internal const val SCALE_Y_MISSING = "Stage prop X scale must not be empty."
        internal const val ROTATION_INVALID = "Stage prop rotation must be between -180 and 180 degrees."
        internal const val BRIGHTNESS_INVALID = "Stage prop brightness must be between 0% and 100%."
        internal const val DISPLAY_ORDER_MISSING = "Stage prop X display order must not be empty."
    }
}
